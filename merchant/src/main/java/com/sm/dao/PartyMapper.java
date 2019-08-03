package com.sm.dao;

import com.sm.model.Party;

public interface PartyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Party record);

    int insertSelective(Party record);

    Party selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Party record);

    int updateByPrimaryKey(Party record);
}