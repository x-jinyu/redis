package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.settings.domain.DicType;
import com.bjpowernode.crm.settings.service.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 王金宇
 * 2020/12/24 0024
 */
@Controller
public class DicTypeController {
    @Autowired
    private DicTypeService dicTypeService;

    @RequestMapping("/settings/dictionary/type/index.do")
    public String index(Model model){
        List<DicType> dicTypeList = dicTypeService.queryAllDicTypes();
        //将数据存到model
        model.addAttribute("dicTypeList",dicTypeList);
        return "settings/dictionary/type/index";
    }

    //新建
    @RequestMapping("/settings/dictionary/type/toSave.do")
    public String toSave(){
        return "settings/dictionary/type/save";
    }

    //确保新建页面code字段没有重复
    @RequestMapping("/settings/dictionary/type/checkCode.do")
    public @ResponseBody Object checkCode(String code){
        //调用service业务层方法，查询字典类型
        DicType dicType = dicTypeService.queryDicTypeByCode(code);
        //根据结果生成响应信息
        ReturnObject returnObject = new ReturnObject();
        if (dicType==null){
            //不重复，code可用
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }else {
            //重复，code不可用
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("编码已存在");
        }
        return returnObject;
    }

    //将新建字典类型保存到数据库中
    @RequestMapping("/settings/dictionary/type/saveCreateDicType.do")
    public @ResponseBody Object saveCreateDicType(DicType dicType){
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = dicTypeService.saveCreateDicType(dicType);
            if (ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else {
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

    //删除数据
    @RequestMapping("/settings/dictionary/type/deleteDicTypeByCodes.do")
    public @ResponseBody Object deleteDicTypeByCodes(String[] code){
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = dicTypeService.deleteDicTypeByCodes(code);
            if (ret>0){
                //删除成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统正忙，请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //删除失败
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统正忙，请稍后重试...");
        }
        return returnObject;
    }

    //修改界面跳转
    @RequestMapping("/settings/dictionary/type/editDicType.do")
    public String editDicType(String code,Model model){
        DicType dicType = dicTypeService.queryDicTypeByCode(code);
        //数据保存到request中
        model.addAttribute("dicType",dicType);
        //请求转发
        return "settings/dictionary/type/edit";
    }
    //更新按钮的请求跳转
    @RequestMapping("/settings/dictionary/type/saveEditDicType.do")
    public @ResponseBody Object saveEditDicType(DicType dicType){
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = dicTypeService.saveEditDicType(dicType);
            if (ret>0){
                //修改成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else {
                //修改失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试...");
            }
        } catch (Exception e){
            e.printStackTrace();
            //修改失败
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统正忙，请稍后重试...");
        }
        return returnObject;
    }
}
