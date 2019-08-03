package com.sm.dao;

import com.sm.model.BodyQualifications;
import com.sm.model.BodyQualificationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BodyQualificationsMapper {
    int countByExample(BodyQualificationsExample example);

    int deleteByExample(BodyQualificationsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BodyQualifications record);

    int insertSelective(BodyQualifications record);

    List<BodyQualifications> selectByExample(BodyQualificationsExample example);

    BodyQualifications selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BodyQualifications record, @Param("example") BodyQualificationsExample example);

    int updateByExample(@Param("record") BodyQualifications record, @Param("example") BodyQualificationsExample example);

    int updateByPrimaryKeySelective(BodyQualifications record);

    int updateByPrimaryKey(BodyQualifications record);
    
    int deleteCertificatePic(BodyQualifications record);
}