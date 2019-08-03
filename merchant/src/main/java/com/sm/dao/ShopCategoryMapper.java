package com.sm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sm.model.ShopCategory;
import com.sm.model.ShopCategoryExample;

public interface ShopCategoryMapper {
    int countByExample(ShopCategoryExample example);

    int deleteByExample(ShopCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    List<ShopCategory> selectByExample(ShopCategoryExample example);

    ShopCategory selectByPrimaryKey(Integer id);
    
    ShopCategory selectShopCategory(Integer id);//查询门店主营分类

    int updateByExampleSelective(@Param("record") ShopCategory record, @Param("example") ShopCategoryExample example);

    int updateByExample(@Param("record") ShopCategory record, @Param("example") ShopCategoryExample example);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);
    
    List<ShopCategory> selectCategory(Integer id);//查询所有商家分类名称
    
    int insertNewCategoryName(ShopCategory record);//添加新的门店分类名称
    
    int deleteByCategoryName(ShopCategory record);// 删除门店分类名称
    
}