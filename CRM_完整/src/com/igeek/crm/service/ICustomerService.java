package com.igeek.crm.service;

import com.igeek.crm.dto.LayUITableData;
import com.igeek.crm.po.Customer;
import com.igeek.crm.vo.UserQueryVo;

/**
 * @author Administrator
 * @create 2019/05/14
 */
public interface ICustomerService {
    LayUITableData<Customer> list(Integer page, Integer limit, UserQueryVo userQueryVo);

    Customer get(Long id);

    int update(Customer customer);

    int delete(Long id);
}
