package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.ShopCategoryMapper;
import com.sm.model.ShopCategory;

@Service
public class ShopCategoryService {

	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	
	public ShopCategory selectByPrimaryKey(Integer id) {		
		return shopCategoryMapper.selectByPrimaryKey(id); 		
	}
	
	public ShopCategory selectShopCategory(Integer id) {		
		return shopCategoryMapper.selectShopCategory(id); 		
	}
	
	public int updateByPrimaryKeySelective(ShopCategory record) {
		return shopCategoryMapper.updateByPrimaryKeySelective(record);
	}
	
	public List<ShopCategory> selectCategory(Integer id) {
    	return shopCategoryMapper.selectCategory(id);
    }
	
	public int insertNewCategoryName(ShopCategory record) {
    	return shopCategoryMapper.insertNewCategoryName(record);
    };
    
    public int deleteByPrimaryKey(Integer id) {
    	return shopCategoryMapper.deleteByPrimaryKey(id);
    };
}
