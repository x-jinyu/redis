package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.DicType;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.service.DicTypeService;
import com.bjpowernode.crm.settings.service.DicValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 王金宇
 * 2020/12/26 0026
 */
@Controller
public class DicValueController {
    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private DicTypeService dicTypeService;

    @RequestMapping("/settings/dictionary/value/index.do")
    public String index(Model model) {
        List<DicValue> dicValueList = dicValueService.queryAllDicValues();
        //将数据写入model中
        model.addAttribute("dicValueList", dicValueList);
        return "settings/dictionary/value/index";
    }

    @RequestMapping("/settings/dictionary/value/toSave.do")
    public String toSave(Model model) {
        List<DicType> dicTypeList = dicTypeService.queryAllDicTypes();
        model.addAttribute("dicTypeList", dicTypeList);
        return "settings/dictionary/value/save";
    }

    @RequestMapping("/settings/dictionary/value/saveCreateDicValue.do")
    public @ResponseBody
    Object saveCreateDicValue(DicValue dicValue) {
        ReturnObject returnObject = new ReturnObject();
        //调用service
        try {
            //设置主键值为uuid
            dicValue.setId(UUIDUtils.getUUID());
            int ret = dicValueService.saveCreateDicValue(dicValue);
            if (ret > 0) {
                //保存成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //保存失败
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("保存失败");
        }
        return returnObject;
    }

    //跳转编辑页面
    @RequestMapping("/settings/dictionary/value/editDicValue.do")
    public String editDicValue(Model model, String id) {
        DicValue dicValue = dicValueService.queryDicValueById(id);
        //将数据写入model中
        model.addAttribute("dicValue", dicValue);
        return "settings/dictionary/value/edit";
    }

    //跳转字典值查看页面
    @RequestMapping("/settings/dictionary/value/saveEditDicValue.do")
    public @ResponseBody
    Object saveEditDicValue(DicValue dicValue) {
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = dicValueService.saveEditDicValue(dicValue);
            if (ret > 0) {
                //修改成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后重试...");
        }
        return returnObject;
    }

    //删除选中的字典值
    @RequestMapping("/settings/dictionary/value/deleteDicValueByIds.do")
    public @ResponseBody Object deleteDicValueByIds(String[] id){
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = dicValueService.deleteDicValueByIds(id);
            if (ret>0){
                //删除成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else {
                //删除失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("删除失败，请联系服务人员...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //删除失败
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败，请联系服务人员...");
        }
        return returnObject;
    }
}
