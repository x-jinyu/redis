package com.crm.dao;

import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.mapper.DicValueMapper;
import com.crm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 王金宇
 * 2020/12/26 0026
 */

public class DicValueDaoTest extends BaseTest {
    @Autowired
    private DicValueMapper dicValueMapper;

    @Test
    public void saveEditDicValueTest(){
        DicValue dicValue = new DicValue();
        dicValue.setValue("222");
        dicValue.setText("222");
        dicValue.setOrderNo("222");

    }
}
