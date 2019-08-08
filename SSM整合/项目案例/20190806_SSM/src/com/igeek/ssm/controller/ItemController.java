package com.igeek.ssm.controller;

import com.igeek.ssm.po.Item;
import com.igeek.ssm.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping("/itemList")
    public String hello(Model model){
        List<Item> list = iItemService.list();
        System.out.println("list====="+list);

        model.addAttribute("items",list);
        return "itemList";
    }

}