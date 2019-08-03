package com.sm.dao;

import com.sm.model.Shop;
import com.sm.model.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    int countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
    
    int insertPhone(Shop record);//添加门店电话	   
    
    Shop selectShopBusinessInfo(Integer id);//根据主键查询门店营业信息
    
    Shop getShopInfo(Integer id);//查门店信息

    Shop selectOpenHours(Integer id);//查营业时间
    
    Shop selectAnnouncement(Integer id);//查询门店公告
    
    Shop selectWarmPrompt(Integer id);//查询门店温馨提示
    
    Shop selectPhone(Integer id);//根据主键查询门店电话
    
    Shop selectLocation(Integer id);//查门店地址
    
    Shop selectShopQrCode(Integer id);//根据主键查询门店二维码
    
    Shop selectShopBaseInfo(Integer id);//根据主键查询门店基本信息
    
    Shop mainCategory(Integer id);//根据主键查询门店主营业务
    
    Shop secondCategory(Integer id);//根据主键查询门店次营业务
}