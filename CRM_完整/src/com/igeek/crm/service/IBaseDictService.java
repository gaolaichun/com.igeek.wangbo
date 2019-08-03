package com.igeek.crm.service;

import com.igeek.crm.po.BaseDict;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/14
 */
public interface IBaseDictService {
    List<BaseDict> list(String dictTypeCode);
}
