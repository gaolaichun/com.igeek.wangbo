package com.sm.dao;

import com.sm.model.PackageCategory;
import com.sm.model.PackageCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackageCategoryMapper {
    int countByExample(PackageCategoryExample example);

    int deleteByExample(PackageCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PackageCategory record);

    int insertSelective(PackageCategory record);

    List<PackageCategory> selectByExample(PackageCategoryExample example);

    PackageCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PackageCategory record, @Param("example") PackageCategoryExample example);

    int updateByExample(@Param("record") PackageCategory record, @Param("example") PackageCategoryExample example);

    int updateByPrimaryKeySelective(PackageCategory record);

    int updateByPrimaryKey(PackageCategory record);
}