package com.igeek.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @create 2019/05/14
 */
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/userList")
    public String userList(){
        return "userList";
    }

    @RequestMapping("/userEdit")
    public String userEdit(){
        return "userEdit";
    }
}
