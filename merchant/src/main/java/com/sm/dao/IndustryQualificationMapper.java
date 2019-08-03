package com.sm.dao;

import com.sm.model.IndustryQualification;
import com.sm.model.IndustryQualificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndustryQualificationMapper {
    int countByExample(IndustryQualificationExample example);

    int deleteByExample(IndustryQualificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndustryQualification record);

    int insertSelective(IndustryQualification record);

    List<IndustryQualification> selectByExample(IndustryQualificationExample example);

    IndustryQualification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndustryQualification record, @Param("example") IndustryQualificationExample example);

    int updateByExample(@Param("record") IndustryQualification record, @Param("example") IndustryQualificationExample example);

    int updateByPrimaryKeySelective(IndustryQualification record);

    int updateByPrimaryKey(IndustryQualification record);
    
    int deleteCertificatePicture(IndustryQualification record);
}