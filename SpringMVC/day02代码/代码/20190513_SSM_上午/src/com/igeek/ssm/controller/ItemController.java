package com.igeek.ssm.controller;

import com.igeek.ssm.po.Item;
import com.igeek.ssm.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/13
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Item> items = itemService.list();
        model.addAttribute("items",items);
        return "itemList";
    }

}
