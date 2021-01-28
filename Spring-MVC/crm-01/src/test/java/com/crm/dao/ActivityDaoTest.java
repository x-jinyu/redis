package com.crm.dao;

import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.crm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * 王金宇
 * 2020/12/28 0028
 */
public class ActivityDaoTest extends BaseTest {
    @Autowired
    private ActivityMapper activityMapper;

    @Test
    public void test1(){
        Activity activity = new Activity();
        activity.setId("abcde");
        activity.setOwner("cjc");
        activityMapper.insertActivity(activity);
    }

    @Test
    public void test2(){
        HashMap map=new HashMap();
        map.put("name","1");
        map.put("beginNo",0);
        map.put("pageSize",2);
        List<Activity> activities=activityMapper.selectActivityForPageByCondition(map);
        System.out.println(activities.size());
    }


}
