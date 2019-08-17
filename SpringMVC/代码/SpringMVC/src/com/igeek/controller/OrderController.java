package com.igeek.controller;

import com.igeek.vo.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 60915
 * \* Date: 2019/8/16
 * \* Time: 23:25
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
public class OrderController {

    @RequestMapping("/search")
    public String search(QueryVo queryVo){
        //获取查询条件进行查询
        System.out.println("queryVo:"+queryVo);
        return "home";
    }
}