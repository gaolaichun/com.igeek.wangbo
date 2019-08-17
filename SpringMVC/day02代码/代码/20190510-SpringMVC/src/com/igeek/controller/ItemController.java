package com.igeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @create 2019/05/13
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("/list")
    public String list(){
        //获取商品列表
        System.out.println("item...list处理器执行...");
        return "itemList";
    }
}
