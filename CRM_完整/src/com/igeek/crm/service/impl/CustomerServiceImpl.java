package com.igeek.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igeek.crm.dto.LayUITableData;
import com.igeek.crm.mapper.CustomerMapper;
import com.igeek.crm.po.Customer;
import com.igeek.crm.po.CustomerExample;
import com.igeek.crm.service.ICustomerService;
import com.igeek.crm.vo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/14
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public LayUITableData<Customer> list(Integer page, Integer limit, UserQueryVo queryVo) {
        //设置分页参数
        PageHelper.startPage(page,limit);

        //执行查询
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        //queryVo.getCustName()!=null&&queryVo.getCustName().equals("")
        //设置查询条件
        if(!StringUtils.isEmpty(queryVo.getCustName())){
            criteria.andCustNameEqualTo(queryVo.getCustName());
        }
        if(!StringUtils.isEmpty(queryVo.getSource())){
            criteria.andCustSourceEqualTo(queryVo.getSource());
        }
        if(!StringUtils.isEmpty(queryVo.getIndustry())){
            criteria.andCustIndustryEqualTo(queryVo.getIndustry());
        }
        if(!StringUtils.isEmpty(queryVo.getLevel())){
            criteria.andCustLevelEqualTo(queryVo.getLevel());
        }

        List<Customer> customers = customerMapper.selectByExample(example);
        //获取mybatis分页对象
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);

        LayUITableData<Customer> layUITableData = new LayUITableData<>();
        layUITableData.setCode(0);
        layUITableData.setMsg("");
        layUITableData.setCount(pageInfo.getTotal());
        layUITableData.setData(customers);
        return layUITableData;
    }

    @Override
    public Customer get(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public int delete(Long id) {
        return customerMapper.deleteByPrimaryKey(id);
    }
}
