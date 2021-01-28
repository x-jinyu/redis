package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.MD5Util;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 王金宇
 * 2020/12/21 0021
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String loginAct = null;
        String loginPwd = null;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("loginAct".equals(name)) {
                loginAct = cookie.getValue();
                continue;
            }
            if ("loginPwd".equals(name)) {
                loginPwd = cookie.getValue();
            }
        }
        if (loginAct != null && loginPwd != null) {
            //封装参数
            Map<String, Object> map = new HashMap<>();
            map.put("loginAct", loginAct);
            map.put("loginPwd", MD5Util.getMD5(loginPwd));
            //调用service
            User user = userService.queryUserByLoginActAndPwd(map);
            request.getSession().setAttribute(Contants.SESSION_USER, user);
            return "redirect:/workbench/index.do";
        } else {
            return "settings/qx/user/login";
        }
    }


    @RequestMapping("/settings/qx/user/login.do")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(loginAct);
        System.out.println(loginPwd);
        System.out.println(isRemPwd);
        String NewloginPwd = MD5Util.getMD5(loginPwd);

        //封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", NewloginPwd);

        User user = userService.queryUserByLoginActAndPwd(map);
        ReturnObject returnObject = new ReturnObject();

        //根据查询结果,生成返回对象中的相关信息,code,message
        if (user == null) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        } else {
            if (DateUtils.formatDateTime(new Date()).compareTo(user.getExpireTime()) > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号时间过期");
            } else if ("0".equals(user.getLockState())) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号已被冻结");
            } else if (!user.getAllowIps().contains(request.getRemoteAddr())) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("ip受限");
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                //user保存到session,以便于后期登录判断 session
                session.setAttribute(Contants.SESSION_USER, user);

                //是否需要免登录功能
                if ("true".equals(isRemPwd)) {
                    Cookie c1 = new Cookie("loginAct", loginAct);
                    c1.setMaxAge(10 * 24 * 60 * 60);
                    response.addCookie(c1);

                    Cookie c2 = new Cookie("loginPwd", loginPwd);
                    c2.setMaxAge(10 * 24 * 60 * 60);
                    response.addCookie(c2);
                } else {
                    Cookie c1 = new Cookie("loginAct", null);
                    c1.setMaxAge(0);
                    response.addCookie(c1);

                    Cookie c2 = new Cookie("loginPwd", null);
                    c2.setMaxAge(0);
                    response.addCookie(c2);
                }
            }
        }
        return returnObject;
    }

    @RequestMapping("/settings/qx/user/logout.do")
    public String logout(HttpServletResponse response,HttpSession session){
        //清空cookie
        Cookie c1 = new Cookie("loginAct", null);
        c1.setMaxAge(0);
        response.addCookie(c1);

        Cookie c2 = new Cookie("loginPwd", null);
        c2.setMaxAge(0);
        response.addCookie(c2);

        //销毁session
        session.invalidate();
        return "redirect:/";
    }
}
