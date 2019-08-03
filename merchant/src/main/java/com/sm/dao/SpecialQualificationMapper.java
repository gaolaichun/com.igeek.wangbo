package com.sm.dao;

import com.sm.model.SpecialQualification;
import com.sm.model.SpecialQualificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialQualificationMapper {
    int countByExample(SpecialQualificationExample example);

    int deleteByExample(SpecialQualificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpecialQualification record);

    int insertSelective(SpecialQualification record);

    List<SpecialQualification> selectByExample(SpecialQualificationExample example);

    SpecialQualification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpecialQualification record, @Param("example") SpecialQualificationExample example);

    int updateByExample(@Param("record") SpecialQualification record, @Param("example") SpecialQualificationExample example);

    int updateByPrimaryKeySelective(SpecialQualification record);

    int updateByPrimaryKey(SpecialQualification record);
    
    SpecialQualification selectShopQualifiStatus(Integer sid);
    
    int deleteCertificatePicture(SpecialQualification record);
}