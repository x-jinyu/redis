package com.crm.service;

import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.service.DicTypeService;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.settings.service.UserService;
import com.crm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 王金宇
 * 2020/12/19 0019
 */
public class DicValueServiceTest extends BaseTest {
    @Autowired
    private DicValueService dicValueService;

    @Test
    public void testinsertDicValue(){
        DicValue dicValue = new DicValue();
        dicValue.setOrderNo("orderNo");
        dicValue.setText("text");
        dicValue.setValue("value");
        dicValue.setTypeCode("1");
        int ret = dicValueService.saveCreateDicValue(dicValue);
        System.out.println(ret);
    }
}
