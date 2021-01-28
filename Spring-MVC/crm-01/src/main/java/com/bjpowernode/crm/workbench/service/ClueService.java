package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.Clue;

import javax.management.Query;
import java.util.Map;

/**
 * 王金宇
 * 2021/1/4 0004
 */
public interface ClueService {
    int saveCreateClue(Clue clue);

    Clue QueryClueForDetailById(String id);

    //保存转换线索
    void saveConvert(Map<String,Object> map);
}