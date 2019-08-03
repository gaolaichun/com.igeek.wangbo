package com.sm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sm.model.PackageCategory;

public interface PackageCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PackageCategory record);

    int insertSelective(PackageCategory record);

    PackageCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PackageCategory record);

    int updateByPrimaryKey(PackageCategory record);
    
    //通过商家id查询商家的所有套餐类别
    List<PackageCategory> selectCategoryBySid(Integer sid);
    
}