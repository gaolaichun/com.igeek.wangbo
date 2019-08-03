package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.SpecialQualificationMapper;
import com.sm.model.SpecialQualification;

@Service
public class SpecialQualificationService {

	@Autowired
	private SpecialQualificationMapper specialQualificationMapper;
	
	public SpecialQualification selectByPrimaryKey(Integer sid) {
		return specialQualificationMapper.selectByPrimaryKey(sid);
	}
		
	public SpecialQualification selectShopQualifiStatus(Integer sid) {
		return specialQualificationMapper.selectShopQualifiStatus(sid);
	}
	
	public int updateByPrimaryKeySelective(SpecialQualification record) {
		return specialQualificationMapper.updateByPrimaryKeySelective(record);
	}
	
	public int insertSelective(SpecialQualification record) {
		return specialQualificationMapper.insertSelective(record);
	}
		
	public int deleteCertificatePicture(SpecialQualification record) {
		return specialQualificationMapper.deleteCertificatePicture(record);
	}
}
