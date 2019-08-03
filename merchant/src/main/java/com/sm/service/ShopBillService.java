package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.ShopBillMapper;
import com.sm.model.ShopBill;

@Service
public class ShopBillService {
	
	@Autowired
	private ShopBillMapper shopBillMapper;

	public int deleteByPrimaryKey(Integer id) {
		return shopBillMapper.deleteByPrimaryKey(id);
	};

	public int insert(ShopBill record) {
		return shopBillMapper.insert(record);
	};

	public int insertSelective(ShopBill record) {
		return shopBillMapper.insertSelective(record);
	};

	public ShopBill selectByPrimaryKey(Integer id) {
		return shopBillMapper.selectByPrimaryKey(id);
	};

	public int updateByPrimaryKeySelective(ShopBill record) {
		return shopBillMapper.updateByPrimaryKeySelective(record);
	};

	public int updateByPrimaryKey(ShopBill record) {
		return shopBillMapper.updateByPrimaryKey(record);
	};
	
	public List<ShopBill>selectByExample(ShopBill record){
		return shopBillMapper.selectByExample(record);
	}
	
	public List<ShopBill>sevenBill(Integer sid){
		return shopBillMapper.sevenBill(sid);
	}
	
	public List<ShopBill> customBill(String startTime,String endTime,Integer id){
		return shopBillMapper.customBill(startTime, endTime, id);
	}
}
