package com.igeek.ssm.controller;

import com.igeek.ssm.po.Item;
import com.igeek.ssm.po.User;
import com.igeek.ssm.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 * @create 2019/05/13
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    private static final String IMAGE_URL_BASE = "http://localhost:8089/pic/";
    private static final String IMAGE_UPLOAD_BASE = "D:\\files\\";

    @Autowired
    private IItemService itemService;

    @RequestMapping("/list")
    public String list(Model model,String keyword) {
        List<Item> items = itemService.list(keyword);
        model.addAttribute("items", items);
        model.addAttribute("keyword",keyword);
        return "itemList";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable() Integer id, Model model) {
        Item item = itemService.get(id);
        model.addAttribute("item", item);
        return "editItem";
    }

    @RequestMapping("/update")
    public String update(Item item, MultipartFile file) {

        //先实现文件的保存
        String originalName = file.getOriginalFilename();
        if (file != null && !"".equals(originalName)) {
            String fileName = UUID.randomUUID().toString();
            fileName += originalName.substring(originalName.lastIndexOf("."));
            try {
                file.transferTo(new File(IMAGE_UPLOAD_BASE + fileName));//图片上传路径
                item.setPic(IMAGE_URL_BASE + fileName);//图片访问路径


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //更新商品
        itemService.update(item);

        return "redirect:/item/list";
    }


    @RequestMapping("/add")
    public String add(Item item, MultipartFile file) {
        //先实现文件的保存
        String originalName = file.getOriginalFilename();
        if (file != null && !"".equals(originalName)) {
            String fileName = UUID.randomUUID().toString();
            fileName += originalName.substring(originalName.lastIndexOf("."));
            try {
                file.transferTo(new File(IMAGE_UPLOAD_BASE + fileName));//图片上传路径
                item.setPic(IMAGE_URL_BASE + fileName);//图片访问路径


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //添加商品
        itemService.add(item);

        return "redirect:/item/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable() Integer id) {
        itemService.delete(id);
        return "redirect:/item/list";
    }

    @RequestMapping("/addItem")
    public String addItem() {
        return "addItem";
    }


    /*查询操作*/
    /*@RequestMapping("/search")
    public String search(String keyword,Model model){
        //根据关键字查询商品列表
        List<Item> items = itemService.listByName(keyword);
        model.addAttribute("items",items);
        model.addAttribute("keyword",keyword);
        return "itemList";
    }*/


}
