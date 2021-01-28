package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * 王金宇
 * 2020/12/28 0028
 */
public interface ActivityServie {

    int saveCreateActivity(Activity activity);

    List<Activity> queryActivityForPageByCondition(Map<String,Object> map);

    long queryCountofActivityByCondition(Map<String,Object> map);

    Activity queryActivityById(String id);

    int saveEditActivity(Activity activity);

    int deleteActivityByIds(String[] ids);

    List<Activity> queryAllActivityForDetail();

    List<Activity> queryActivityForDetailByIds(String[] ids);

    int saveCreateActivityByList(List<Activity> activityList);

    Activity queryActivityForDetailById(String id);

    List<Activity> queryActivityForDetailByClueId(String cludeId);

    List<Activity> searchActivityNoBoundById(Map<String,Object> map);
}
