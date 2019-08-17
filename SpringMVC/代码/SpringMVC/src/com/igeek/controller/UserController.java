package com.igeek.controller;

import com.igeek.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 60915
 * \* Date: 2019/8/14
 * \* Time: 22:59
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
public class UserController {

    /*
    * 编写一个处理器，当用户访问/user/list时，打印用户列表
    */
//    @RequestMapping("/user/list")
//    public ModelAndView userList(){
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("1","张三",20,"1"));
//        users.add(new User("2","李四",19,"1"));
//        users.add(new User("3","王五",22,"2"));
//        users.add(new User("4","赵六",21,"1"));
//
//        modelAndView.setViewName("userList");//设置视图名等价与转发
//        modelAndView.addObject("users",users);
//
//        System.out.println("users======"+users);
//
//        return modelAndView;
//    }



    /*@RequestMapping("/home")
    public ModelAndView home(){
        //创建模型以及试图对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }*/

    //第二种写法
    @RequestMapping("/home")
    public String home(){
        return "home";
    }


    /*@RequestMapping("/login")
    public String login(String username,String password){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "home";
    }*/

    /*@RequestMapping("/register")
    public String register(String no,String name,String age,String sex){
        System.out.println("username:"+no);
        System.out.println("password:"+name);
        System.out.println("password:"+age);
        System.out.println("password:"+sex);
        return "home";
    }*/


    @RequestMapping("/register")
    public String register(User user){

        System.out.println("user:"+user);
        return "home";
    }

    //@CookieValue("/cookie的name")
    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue("JSESSIONID") String sessionId  /*HttpServletRequest request*/){

        System.out.println("sessionId:"+sessionId);
        //方式一
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies){
//            if ("JSESSIONID".equals(cookie.getName())){
//                System.out.println("JSESSIONID==>"+cookie.getValue());
//            }
//        }
        return "home";
    }


//    @RequestMapping("/user/list")
//    public String userList(Model model){
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("1","张三",20,"1"));
//        users.add(new User("2","李四",19,"1"));
//        users.add(new User("3","王五",22,"2"));
//        users.add(new User("4","赵六",21,"1"));
//
//        model.addAttribute("users",users);
//
//        System.out.println("users======"+users);
//
//        return "userList";
//    }


//    @RequestMapping("/user/list")
//    public String userList(ModelMap modelMap){
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("1","张三",20,"1"));
//        users.add(new User("2","李四",19,"1"));
//        users.add(new User("3","王五",22,"2"));
//        users.add(new User("4","赵六",21,"1"));
//
//        modelMap.addAttribute("users",users);
//
//        System.out.println("users======"+users);
//
//        return "userList";
//    }



//    @RequestMapping("/user/list")
//    public String userList(Map<String,Object > map){
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("1","张三",20,"1"));
//        users.add(new User("2","李四",19,"1"));
//        users.add(new User("3","王五",22,"2"));
//        users.add(new User("4","赵六",21,"1"));
//
//        map.put("users",users);
//
//        System.out.println("users======"+users);
//
//        return "userList";
//    }

    @RequestMapping("/user/list")
    public String userList(Model model){

        List<User> users = new ArrayList<>();
        users.add(new User("1","张三",20,"1"));
        users.add(new User("2","李四",19,"1"));
        users.add(new User("3","王五",22,"2"));
        users.add(new User("4","赵六",21,"1"));

        model.addAttribute("users",users);

        System.out.println("users======"+users);

        return "userList";
    }





}
































