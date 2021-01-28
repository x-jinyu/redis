package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.ActivityRemark;

import java.util.List;

/**
 * 王金宇
 * 2021/1/5 0005
 */
public interface ActivityRemarkService {

    //根据activityId查询该市场活动下所有的备注明细信息
    List<ActivityRemark> queryActivityRemarkForDetailByActivityId(String activityId);

    //保存创建的市场活动备注
    int saveCreateActivityRemark(ActivityRemark remark);

    //根据id删除市场活动备注
    int deleteActivityRemarkById(String id);

    //保存修改的市场活动备注
    int saveEditActivityRemark(ActivityRemark remark);
}
