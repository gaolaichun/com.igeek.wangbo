package com.igeek.ssm.service.impl;

import com.igeek.ssm.mapper.ItemMapper;
import com.igeek.ssm.mapper.UserMapper;
import com.igeek.ssm.po.Item;
import com.igeek.ssm.po.ItemExample;
import com.igeek.ssm.po.User;
import com.igeek.ssm.service.IItemService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/13
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> list(String keyword) {
        ItemExample example = new ItemExample();
        if(keyword!=null&&!"".equals(keyword)){
            ItemExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%"+keyword+"%");
        }
        return itemMapper.selectByExample(example);
    }

    @Override
    public Item get(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Item item) {
        return itemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public int delete(Integer id) {
        return itemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(Item item) {
        return itemMapper.insert(item);
    }

    /*@Override
    public List<Item> listByName(String keyword) {
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+keyword+"%");
        return itemMapper.selectByExample(example);
    }*/
}
