package com.sm.dao;

import com.sm.model.Package;
import com.sm.model.PackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackageMapper {
    int countByExample(PackageExample example);

    int deleteByExample(PackageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Package record);

    int insertSelective(Package record);

    List<Package> selectByExample(PackageExample example);

    Package selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Package record, @Param("example") PackageExample example);

    int updateByExample(@Param("record") Package record, @Param("example") PackageExample example);

    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKey(Package record);
}