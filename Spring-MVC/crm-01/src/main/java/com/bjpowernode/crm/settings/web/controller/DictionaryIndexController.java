package com.bjpowernode.crm.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 王金宇
 * 2020/12/24 0024
 */
@Controller
public class DictionaryIndexController {
    @RequestMapping("settings/dictionary/index.do")
    public String index(){
        return "settings/dictionary/index";
    }
}
