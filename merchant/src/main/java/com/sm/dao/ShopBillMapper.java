package com.sm.dao;

import java.util.List;

import com.sm.model.ShopBill;

public interface ShopBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopBill record);

    int insertSelective(ShopBill record);

    ShopBill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopBill record);

    int updateByPrimaryKey(ShopBill record);
    
    List<ShopBill> selectByExample(ShopBill record);
    
    List<ShopBill> sevenBill(Integer sid);
    
    List<ShopBill> customBill(String startTime,String endTime,Integer id);
}