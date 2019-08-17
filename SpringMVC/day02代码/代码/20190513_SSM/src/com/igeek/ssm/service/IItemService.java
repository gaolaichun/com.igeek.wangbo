package com.igeek.ssm.service;

import com.igeek.ssm.po.Item;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/13
 */
public interface IItemService {

    List<Item> list(String keyword);

    Item get(Integer id);

    int update(Item item);

    int delete(Integer id);

    int add(Item item);

    //List<Item> listByName(String keyword);
}
