package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.domain.ActivityRemark;
import com.bjpowernode.crm.workbench.domain.Clue;
import com.bjpowernode.crm.workbench.domain.ClueActivityRelation;
import com.bjpowernode.crm.workbench.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 王金宇
 * 2021/1/4 0004
 */
@Controller
public class ClueController {
    @Autowired
    private UserService userService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private ClueService clueService;


    @Autowired
    private ActivityServie activityServie;

    @Autowired
    private ActivityRemarkService activityRemarkService;

    @Autowired
    private ClueActivityRelationService clueActivityRelationService;

    @RequestMapping("/workbench/clue/index.do")
    public String index(Model model) {
        System.out.println("ok");
        List<User> userList = userService.queryAllUsers();
        List<DicValue> appellationList = dicValueService.queryDicValueByTypeCode("appellation");
        List<DicValue> clueStateList = dicValueService.queryDicValueByTypeCode("clueState");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");

        model.addAttribute("userList", userList);
        model.addAttribute("appellationList", appellationList);
        model.addAttribute("clueStateList", clueStateList);
        model.addAttribute("sourceList", sourceList);

        return "workbench/clue/index";
    }

    @RequestMapping("/workbench/clue/saveCreateClue.do")
    @ResponseBody
    public Object saveCreateClue(Clue clue, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        //程序员给的数据,基它数据已经自动封装,注意,参数和clue中属性名要一致
        clue.setId(UUIDUtils.getUUID());
        clue.setCreateBy(user.getId());
        clue.setCreateTime(DateUtils.formatDateTime(new Date()));

        ReturnObject returnObject = new ReturnObject();
        int ret = clueService.saveCreateClue(clue);
        if (ret > 0) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/detailClue.do")
    public String detailClue(String id, Model model) {
        //1.线索详情
        //2.备注信息
        //3.市场活动
        Clue clue = clueService.QueryClueForDetailById(id);
        List<ActivityRemark> remarkList = activityRemarkService.queryActivityRemarkForDetailByActivityId(id);
        List<Activity> activityList = activityServie.queryActivityForDetailByClueId(id);
        model.addAttribute("clue", clue);
        model.addAttribute("remarkList", remarkList);
        model.addAttribute("activityList", activityList);

        return "workbench/clue/detail";
    }

    //关联按钮绑定
    @RequestMapping("/workbench/clue/saveBundActivity.do")
    @ResponseBody
    public Object saveBundActivity(String[] activityId, String clueId) {
        //封装参数
        ClueActivityRelation relation = null;
        List<ClueActivityRelation> relationList = new ArrayList<>();
        for (String ai : activityId) {
            relation = new ClueActivityRelation();
            relation.setId(UUIDUtils.getUUID());
            relation.setActivityId(ai);
            relation.setClueId(clueId);
            relationList.add(relation);
        }
        ReturnObject returnObject = new ReturnObject();

        int ret = clueActivityRelationService.saveCreateClueActivityRelationByList(relationList);
        if (ret > 0) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            //查询activityId市场活动得信息
            List<Activity> activityList = activityServie.queryActivityForDetailByIds(activityId);
            returnObject.setRetData(activityList);
        }
        return returnObject;
    }

    //
    @RequestMapping("/workbench/clue/searchActivity.do")
    @ResponseBody
    public Object searchActivity(String activityName, String clueId) {
        Map<String, Object> map = new HashMap<>();
        map.put("activityName", activityName);
        map.put("clueId", clueId);
        List<Activity> activityList = activityServie.searchActivityNoBoundById(map);
        return activityList;
    }

    @RequestMapping("/workbench/clue/saveUnbundActivity.do")
    @ResponseBody
    public Object saveUnbundActivity(ClueActivityRelation relation) {
        ReturnObject returnObject = new ReturnObject();
        int ret = clueActivityRelationService.deleteClueActivityRelationByClueIdActivityId(relation);
        if (ret > 0) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/convertClue.do")
    public String convertClue(String id, Model model) {
        //调用service方法，查询数据
        Clue clue = clueService.QueryClueForDetailById(id);
        List<DicValue> stageList = dicValueService.queryDicValueByTypeCode("stage");
        //数据保存到request
        model.addAttribute("clue", clue);
        model.addAttribute("stageList", stageList);
        //请求转发
        return "workbench/clue/convert";
    }

    @RequestMapping("/workbench/clue/saveConvertClue.do")
    @ResponseBody
    public Object saveConvertClue(String clueId, String isCreateTran, String amountOfMoney, String tradeName, String expectedClosingDate,
                                  String stage, String activityId, HttpSession session) {
        ReturnObject returnObject = new ReturnObject();
        //封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("clueId", clueId);
        map.put("isCreateTran", isCreateTran);
        map.put("amountOfMoney", amountOfMoney);
        map.put("tradeName", tradeName);
        map.put("expectedClosingDate", expectedClosingDate);
        map.put("stage", stage);
        map.put("activityId", activityId);

        map.put("sessionUser", session.getAttribute(Contants.SESSION_USER));
        //调用业务层处理线索转换
        clueService.saveConvert(map);
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        return returnObject;
    }
}
