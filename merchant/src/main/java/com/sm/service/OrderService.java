package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.OrderMapper;
import com.sm.model.Order;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		return orderMapper.deleteByPrimaryKey(id);
	};

    public int insert(Order record) {
    	return orderMapper.insert(record);
    };

    public int insertSelective(Order record) {
    	return orderMapper.insertSelective(record);
    };

    public Order selectByPrimaryKey(Integer id) {
    	return orderMapper.selectByPrimaryKey(id);
    };

    public int updateByPrimaryKeySelective(Order record) {
    	return orderMapper.updateByPrimaryKeySelective(record);
    };

    public int updateByPrimaryKey(Order record) {
    	return orderMapper.updateByPrimaryKey(record);
    };
    
    public List<Order>todayOrder(Integer id,Integer orderStatus){
    	return orderMapper.todayOrder(id,orderStatus);
    }
    
    public List<Order>seventOrder(Integer id,Integer orderStatus){
    	return orderMapper.seventOrder(id,orderStatus);
    }
    
    public List<Order>yesterOrder(Integer id,Integer orderStatus){
    	return orderMapper.yesterOrder(id,orderStatus);
    }
    
    public List<Order>merchantOrder(Order order){
    	return orderMapper.merchantOrder(order);
    }
    
    public Order searchOrder(String orderNo) {
    	return orderMapper.searchOrder(orderNo);
    }
}
