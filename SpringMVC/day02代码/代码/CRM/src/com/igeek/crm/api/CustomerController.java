package com.igeek.crm.api;

import com.igeek.crm.po.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/list")
    public  list(){

    }
}
