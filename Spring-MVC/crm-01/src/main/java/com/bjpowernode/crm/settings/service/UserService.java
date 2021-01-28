package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 王金宇
 * 2020/12/19 0019
 */
public interface UserService {
    User queryUserByLoginActAndPwd(Map<String,Object> map);

    List<User> queryAllUsers();

}
