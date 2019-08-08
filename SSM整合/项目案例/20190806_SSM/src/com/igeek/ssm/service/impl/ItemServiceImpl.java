package com.igeek.ssm.service.impl;

import com.igeek.ssm.mapper.ItemMapper;
import com.igeek.ssm.po.Item;
import com.igeek.ssm.po.ItemExample;
import com.igeek.ssm.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 60915
 * \* Date: 2019/8/6
 * \* Time: 22:48
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> list(){

        ItemExample example = new ItemExample();

        return itemMapper.selectByExample(example);
    }


}