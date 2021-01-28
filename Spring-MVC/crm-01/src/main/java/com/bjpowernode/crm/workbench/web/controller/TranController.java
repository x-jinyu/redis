package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.domain.Customer;
import com.bjpowernode.crm.workbench.domain.Tran;
import com.bjpowernode.crm.workbench.domain.TranHistory;
import com.bjpowernode.crm.workbench.domain.TranRemark;
import com.bjpowernode.crm.workbench.service.CustomerService;
import com.bjpowernode.crm.workbench.service.TranHistoryService;
import com.bjpowernode.crm.workbench.service.TranRemarkService;
import com.bjpowernode.crm.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 王金宇
 * 2021/1/8 0008
 */
@Controller
public class TranController {
    @Autowired
    DicValueService dicValueService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    //处理交易
    @Autowired
    private TranService tranService;

    //交易备注
    @Autowired
    private TranRemarkService tranRemarkService;

    //交易历史
    @Autowired
    private TranHistoryService tranHistoryService;

    @RequestMapping("/workbench/transaction/index.do")
    public String index(Model model) {
        List<DicValue> stageList = dicValueService.queryDicValueByTypeCode("stage");
        List<DicValue> transactionTypeList = dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");

        //数据保存到request
        model.addAttribute("stageList", stageList);
        model.addAttribute("transactionTypeList", transactionTypeList);
        model.addAttribute("sourceList", sourceList);

        //请求转发
        return "workbench/transaction/index";
    }

    @RequestMapping("/workbench/transaction/createTran.do")
    public String createTran(Model model) {
        //调用各自的业务层完成数据的获取
        List<User> userList = userService.queryAllUsers();

        //取字典值
        List<DicValue> transactionTypeList = dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> stageList = dicValueService.queryDicValueByTypeCode("stage");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");

        model.addAttribute("userList", userList);
        model.addAttribute("transactionTypeList", transactionTypeList);
        model.addAttribute("stageList", stageList);
        model.addAttribute("sourceList", sourceList);

        return "workbench/transaction/save";
    }

    @RequestMapping("/workbench/transaction/queryCustomerByName.do")
    @ResponseBody
    public Object queryCustomerByName(String customerName) {
        List<Customer> customerList = customerService.queryCustomerByName(customerName);
        return customerList;
    }

    //根据stage名获取对应的可能性的值
    @RequestMapping("/workbench/transaction/getPossibilityByStageValue.do")
    @ResponseBody
    public Object getPossibilityByStageValue(String stageValue) {
        //绑定资源文件
        ResourceBundle bundle = ResourceBundle.getBundle("possibility");
        String possibility = bundle.getString(stageValue);
        return possibility;
    }

    //保存交易
    @RequestMapping("/workbench/transaction/saveCreateTran.do")
    @ResponseBody
    public Object saveCreateTran(Tran tran, String customerName, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);

        //封装在tran中没有的数据,但是这些数据在tbl_tran表中又需要
        tran.setId(UUIDUtils.getUUID());
        tran.setCreateBy(user.getId());
        tran.setCreateTime(DateUtils.formatDateTime(new Date()));

        //map传递到dao
        Map<String, Object> map = new HashMap<>();
        map.put("tran", tran);
        map.put("customerName", customerName);
        map.put("sessionUser", user);

        //返回对象
        ReturnObject returnObject = new ReturnObject();
        tranService.saveCreateTran(map);
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        return returnObject;
    }

    //通过tran id获取tran的详情
    @RequestMapping("/workbench/transaction/detailTran.do")
    public String detailTran(String id, Model model) {
        //调用业务层,获取这条交易详细信息
        Tran tran=tranService.queryTranForDetailById(id);
        //交易备注
        List<TranRemark> remarkList=tranRemarkService.queryTranRemarkForDetailByTranId(id);
        //交易历史
        List<TranHistory> tranHistoryList=tranHistoryService.queryTranHistoryForDetailByTranId(id);

        //获取当前阶段的分值,在数据库tbl_tran中没有possibility的字段,但是在Tran中有possibility属性,从possibility.properties中获取当前阶段的分会
        ResourceBundle bundle=ResourceBundle.getBundle("possibility");
        String possibility=bundle.getString(tran.getStage());
        tran.setPossibility(possibility);

        //为了显示交易的图标信息,查询所有交易阶段
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");

        //把数据保存到model中返回给前端
        model.addAttribute("tran",tran);
        model.addAttribute("remarkList",remarkList);
        model.addAttribute("tranHistoryList",tranHistoryList);
        model.addAttribute("possibility",possibility);
        model.addAttribute("stageList",stageList);

        //判断交易图标
        TranHistory tranHistory=null;
        for(int i=tranHistoryList.size()-1;i>=0;i--){
            tranHistory=tranHistoryList.get(i);
            int num=Integer.parseInt(stageList.get(stageList.size()-3).getOrderNo());
            if((Integer.parseInt(tranHistory.getOrderNo()) < Integer.parseInt(stageList.get(stageList.size()-3).getOrderNo()))){
                model.addAttribute("theOrderNo",tranHistory.getOrderNo());
                break;
            }
        }
        return "workbench/transaction/detail";
    }
}
