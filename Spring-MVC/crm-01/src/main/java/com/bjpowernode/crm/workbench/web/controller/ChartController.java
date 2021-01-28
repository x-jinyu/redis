package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.workbench.domain.FunnelVO;
import com.bjpowernode.crm.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 王金宇
 * 2021/1/11 0011
 */
@Controller
public class ChartController {
    @Autowired
    private TranService tranService;


    @RequestMapping("/workbench/chart/transaction/index.do")
    public String index(){
        return "workbench/chart/transaction/index";
    }


    //跳转请求，将交易统计表以漏斗形式显示
    @RequestMapping("/workench/chart/transaction/queryCountOfTranGroupByStage.do")
    @ResponseBody
    public Object queryCountOfTranGroupByStage(){
        List<FunnelVO> funnelVOList = tranService.queryCountOfTranGroupByStage();
        return funnelVOList;
    }
}
