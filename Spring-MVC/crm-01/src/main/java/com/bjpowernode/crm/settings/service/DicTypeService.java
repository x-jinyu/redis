package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.DicType;

import java.util.List;

/**
 * 王金宇
 * 2020/12/24 0024
 */
public interface DicTypeService {
    List<DicType> queryAllDicTypes();

    DicType queryDicTypeByCode(String code);

    int saveCreateDicType(DicType dicType);

    int saveEditDicType(DicType dicType);

    int deleteDicTypeByCodes(String[] codes);
}
