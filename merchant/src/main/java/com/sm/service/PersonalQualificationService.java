package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.PersonalQualificationMapper;
import com.sm.model.PersonalQualification;

@Service
public class PersonalQualificationService {
	@Autowired
	private PersonalQualificationMapper personalQualificationMapper;
	
	public PersonalQualification selectByPrimaryKey(Integer sid) {
		return personalQualificationMapper.selectByPrimaryKey(sid);
	}
	
	public PersonalQualification selectPerStatus(Integer sid) {
		return personalQualificationMapper.selectPerStatus(sid);
	}
	
	public  int updateByPrimaryKeySelective(PersonalQualification record) {
		return personalQualificationMapper.updateByPrimaryKeySelective(record);
	}
	
	public  int insertSelective(PersonalQualification record) {
		return personalQualificationMapper.insertSelective(record);
	}
	
	public int deleteCertificatePicture(PersonalQualification record) {
		return personalQualificationMapper.deleteCertificatePicture(record);
	}
}
