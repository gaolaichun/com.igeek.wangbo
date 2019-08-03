package com.igeek.crm.service.impl;

import com.igeek.crm.mapper.BaseDictMapper;
import com.igeek.crm.po.BaseDict;
import com.igeek.crm.po.BaseDictExample;
import com.igeek.crm.service.IBaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/14
 */
@Service
public class BaseDictServiceImpl implements IBaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> list(String dictTypeCode) {
        //根据类型进行查询
        BaseDictExample example = new BaseDictExample();
        BaseDictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeCodeEqualTo(dictTypeCode);
        return baseDictMapper.selectByExample(example);
    }
}
