package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.DicValue;

import java.util.List;
import java.util.Map;

/**
 * 王金宇
 * 2020/12/26 0026
 */
public interface DicValueService {

    List<DicValue> queryAllDicValues();

    DicValue queryDicValueById(String id);

    int saveCreateDicValue(DicValue dicValue);

    int saveEditDicValue(DicValue dicValue);

    int deleteDicValueByIds(String[] id);

    Map<String, List<DicValue>> getAll();

    List<DicValue> queryDicValueByTypeCode(String typeCode);
}
