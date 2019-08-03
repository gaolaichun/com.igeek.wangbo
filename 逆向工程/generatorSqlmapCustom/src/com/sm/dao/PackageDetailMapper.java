package com.sm.dao;

import com.sm.model.PackageDetail;
import com.sm.model.PackageDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackageDetailMapper {
    int countByExample(PackageDetailExample example);

    int deleteByExample(PackageDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PackageDetail record);

    int insertSelective(PackageDetail record);

    List<PackageDetail> selectByExample(PackageDetailExample example);

    PackageDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PackageDetail record, @Param("example") PackageDetailExample example);

    int updateByExample(@Param("record") PackageDetail record, @Param("example") PackageDetailExample example);

    int updateByPrimaryKeySelective(PackageDetail record);

    int updateByPrimaryKey(PackageDetail record);
}