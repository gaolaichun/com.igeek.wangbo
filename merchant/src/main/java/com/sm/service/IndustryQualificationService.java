package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.IndustryQualificationMapper;
import com.sm.model.IndustryQualification;

@Service
public class IndustryQualificationService {

	@Autowired
	private  IndustryQualificationMapper industryQualificationMapper;
	
	public IndustryQualification selectByPrimaryKey(Integer sid) {
		return industryQualificationMapper.selectByPrimaryKey(sid);
	}	
	    
	public  int updateByPrimaryKey(IndustryQualification record) {
		return industryQualificationMapper.updateByPrimaryKey(record);
	}
	
	public  int updateByPrimaryKeySelective(IndustryQualification record) {
		return industryQualificationMapper.updateByPrimaryKeySelective(record);
	}
	
	public  int deleteCertificatePicture(IndustryQualification record) {
		return industryQualificationMapper.deleteCertificatePicture(record);
	}
	
	public int insertSelective(IndustryQualification record) {
		return industryQualificationMapper.insertSelective(record);
	}
}
