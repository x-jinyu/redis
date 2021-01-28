package com.bjpowernode.crm.settings.mapper;

import com.bjpowernode.crm.settings.domain.DicType;
import com.bjpowernode.crm.settings.domain.DicValue;

import java.util.List;

public interface DicValueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dic_value
     *
     * @mbggenerated Thu May 21 09:23:58 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dic_value
     *
     * @mbggenerated Thu May 21 09:23:58 CST 2020
     */
    int insert(DicValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dic_value
     *
     * @mbggenerated Thu May 21 09:23:58 CST 2020
     */
    int insertSelective(DicValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dic_value
     *
     * @mbggenerated Thu May 21 09:23:58 CST 2020
     */
    DicValue selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dic_value
     *
     * @mbggenerated Thu May 21 09:23:58 CST 2020
     */
    int updateByPrimaryKeySelective(DicValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dic_value
     *
     * @mbggenerated Thu May 21 09:23:58 CST 2020
     */
    int updateByPrimaryKey(DicValue record);

    //查询所有得数据字典值
    List<DicValue> selectAllDicValues();

    //保存创建得数据字典类型
    int insertDicValue(DicValue dicValue);

    //根据code查询数据字典类型
    DicValue selectDicValueById(String id);

    //更新
    int updateDicValue(DicValue dicValue);

    //删除
    int deleteDicValueByIds(String[] id);

    //根据typeCode查询数据字典值
    List<DicValue> selectDicValueByTypeCode(String typeCode);


}