package com.igeek.crm.api;

import com.igeek.crm.dto.LayUITableData;
import com.igeek.crm.dto.ResultData;
import com.igeek.crm.po.Customer;
import com.igeek.crm.service.ICustomerService;
import com.igeek.crm.vo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/14
 */
@Controller
@RequestMapping("/api/customer")
@ResponseBody
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    /**
     *
     * @param page 当前页
     * @param limit 每页条数
     * @return
     */
    @RequestMapping("/list")
    public LayUITableData<Customer> list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer limit, UserQueryVo queryVo){
        return customerService.list(page,limit,queryVo);
    }


    @RequestMapping("/get/{id}")
    public Customer get(@PathVariable Long id){
        return customerService.get(id);
    }

    @RequestMapping("/update")
    public ResultData update(Customer customer){
        int result = customerService.update(customer);
        if(result==1){
            return new ResultData(200,"成功",null);
        }else{
            return new ResultData(300,"更新失败",null);
        }

    }

    @RequestMapping("/delete/{id}")
    public ResultData delete(@PathVariable Long id){

        customerService.delete(id);
        return new ResultData(200,"成功",null);
    }
}
