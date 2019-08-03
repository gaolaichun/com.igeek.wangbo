package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.ShopPictureMapper;
import com.sm.model.ShopPicture;

@Service
public class ShopPictureService {
	
	@Autowired
	private ShopPictureMapper shopPictureMapper;
	
	 public List<ShopPicture> selectShopPicture(ShopPicture record){
	    	return shopPictureMapper.selectShopPicture(record);
	    }	 
	
	 public  int selectShopCountpic(Integer sid,Integer pictureCategory) {
			return shopPictureMapper.selectShopCountpic(sid,pictureCategory);
		}
	 
	 public  int updateShopPic(ShopPicture record) {
			return shopPictureMapper.updateShopPic(record);
		}
	 
	 public int updateByPrimaryKeySelective(ShopPicture record) {
		 	return shopPictureMapper.updateByPrimaryKeySelective(record);
	 }
	 
	 public int deleteByPrimaryKey(Integer id) {
		 	return shopPictureMapper.deleteByPrimaryKey(id);
	 }
	 
	 public int insertShopPic(ShopPicture record) {
	    	return shopPictureMapper.insertShopPic(record);
	    };
	    
	 public ShopPicture selectShopPicStatus(Integer id) {
			return shopPictureMapper.selectShopPicStatus(id);
	}
	 
	 public ShopPicture selectAll() {
		 return shopPictureMapper.selectAll();
	 }
}
