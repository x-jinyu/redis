package com.crm.dao;

import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.crm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * 王金宇
 * 2020/12/19 0019
 */
public class UserDaoTest extends BaseTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUserByNameAndPassword(){
        HashMap map = new HashMap();
        map.put("loginAct","ls");
        map.put("loginPwd","44ba5ca65651b4f36f1927576dd35436");
        User user = userMapper.selectUserByLoginActAndPwd(map);
        System.out.println(user.getName());
    }

    @Test
    public void testSelectAllUsers(){
        List<User> users = userMapper.selectAllUsers();
        System.out.println(users.size());
    }
}
