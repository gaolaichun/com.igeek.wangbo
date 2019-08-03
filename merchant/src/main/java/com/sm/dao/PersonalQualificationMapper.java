package com.sm.dao;

import com.sm.model.PersonalQualification;
import com.sm.model.PersonalQualificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalQualificationMapper {
    int countByExample(PersonalQualificationExample example);

    int deleteByExample(PersonalQualificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonalQualification record);

    int insertSelective(PersonalQualification record);

    List<PersonalQualification> selectByExample(PersonalQualificationExample example);

    PersonalQualification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonalQualification record, @Param("example") PersonalQualificationExample example);

    int updateByExample(@Param("record") PersonalQualification record, @Param("example") PersonalQualificationExample example);

    int updateByPrimaryKeySelective(PersonalQualification record);

    int updateByPrimaryKey(PersonalQualification record);
    
    PersonalQualification selectPerStatus(Integer sid);//查询个人身份认证认证状态
    
    int deleteCertificatePicture(PersonalQualification record);
}