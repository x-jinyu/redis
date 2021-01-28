package com.bjpowernode.crm.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 王金宇
 * 2020/12/24 0024
 */
@Controller
public class SettingsIndexController {
    @RequestMapping("settings/index.do")
    public String index(){
        return "settings/index";
    }
}
