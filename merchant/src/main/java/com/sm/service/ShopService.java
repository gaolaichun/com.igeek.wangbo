package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.ShopMapper;
import com.sm.model.Shop;

@Service
public class ShopService {

	@Autowired
	private ShopMapper shopMapper;

	public Shop selectByPrimaryKey(Integer id) {
		return shopMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(Shop record) {
		return shopMapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(Shop record) {
		return shopMapper.updateByPrimaryKeySelective(record);
	}

	public int insertPhone(Shop record) {
		return shopMapper.insertPhone(record);
	}
	
	public int insertSelective(Shop record) {
		return shopMapper.insertSelective(record);
	}

	public Shop selectShopBusinessInfo(Integer id) {
		return shopMapper.selectShopBusinessInfo(id);
	}

	public Shop getShopInfo(Integer id) {
		return shopMapper.getShopInfo(id);
	}

	public Shop selectOpenHours(Integer id) {
		return shopMapper.selectOpenHours(id);
	}
	
	public Shop selectAnnouncement(Integer id) {
		return shopMapper.selectAnnouncement(id);
	}
	
	public Shop selectWarmPrompt(Integer id) {
		return shopMapper.selectWarmPrompt(id);
	}	
	
	public Shop selectPhone(Integer id) {
		return shopMapper.selectPhone(id);
	}
	
	public Shop selectLocation(Integer id) {
		return shopMapper.selectLocation(id);
	}
	
	public Shop selectShopQrCode(Integer id) {
		return shopMapper.selectShopQrCode(id);
	}

	public Shop selectShopBaseInfo(Integer id) {
		return shopMapper.selectShopBaseInfo(id);
	}
}
