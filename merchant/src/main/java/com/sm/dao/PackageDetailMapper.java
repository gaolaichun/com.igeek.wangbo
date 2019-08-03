package com.sm.dao;

import java.util.List;

import com.sm.model.PackageDetail;

public interface PackageDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PackageDetail record);

    int insertSelective(PackageDetail record);

    PackageDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PackageDetail record);

    int updateByPrimaryKey(PackageDetail record);
    
    //通过套餐id删除套餐详情。
    int delectByPackageId(Integer packageId);
    
    //通过套餐id查询套餐中的所有单品的详情
    List<PackageDetail> selectPackageDetailById(Integer packageId);
}