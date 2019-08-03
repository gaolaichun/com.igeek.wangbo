package com.sm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sm.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order>todayOrder(Integer id,Integer orderStatus);
    
    List<Order>seventOrder(Integer id,Integer orderStatus);
    
    List<Order>yesterOrder(Integer id,Integer orderStatus);
    
    List<Order>merchantOrder(Order record);
    
    
    //通过套餐id查询昨日的销量并按当日销量排序
    int selectNumberByOneDay(Integer packageId);
    //通过套餐id查询近七日/近30日的销量并按当周/当月销量排序
    int selectNumberByWeek(@Param("packageId")Integer packageId,@Param("times")Integer times);
    //通过套餐id和用户输入的时间段查询套餐以及销量排序
    int selectNumberByTimeInterval(@Param("packageId")Integer packageId,@Param("startTime")String startTime, @Param("endTime")String endTime);
    
    Order searchOrder(String orderNo);
}
