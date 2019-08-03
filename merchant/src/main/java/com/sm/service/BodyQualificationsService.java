package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.BodyQualificationsMapper;
import com.sm.model.BodyQualifications;

@Service
public class BodyQualificationsService {
	@Autowired
	private  BodyQualificationsMapper bodyQualificationsMapper;
	
	public BodyQualifications selectByPrimaryKey(Integer id) {
		return bodyQualificationsMapper.selectByPrimaryKey(id);
	}
	
	public  int updateByPrimaryKey(BodyQualifications record) {
		return bodyQualificationsMapper.updateByPrimaryKeySelective(record);
	}
	
	public  int updateByPrimaryKeySelective(BodyQualifications record) {
		return bodyQualificationsMapper.updateByPrimaryKeySelective(record);
	}
	
	public  int deleteCertificatePic(BodyQualifications record) {
		return bodyQualificationsMapper.deleteCertificatePic(record);
	}
	
	public int insertSelective(BodyQualifications record) {
		return bodyQualificationsMapper.insertSelective(record);
	}
}
