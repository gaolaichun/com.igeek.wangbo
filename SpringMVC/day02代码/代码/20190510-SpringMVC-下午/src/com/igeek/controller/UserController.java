package com.igeek.controller;

import com.igeek.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

;import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author Administrator
 * @create 2019/05/10
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"msg"})//将msg数据在session中也保存一份
public class UserController {

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * @RequestMapping 通过该注解指定处理器映射规则(也即当访问哪个url时执行该方法)
     * @return 逻辑视图名
     */
    @RequestMapping(value={"/home","/index"},method = {RequestMethod.POST,RequestMethod.GET})
    public String index(Integer tag) throws MyException {
        //逻辑处理...

        int i = 10/0;//运行时异常
        //假设用户账号被锁定
        if(tag==0){
            throw new MyException("用户已锁定");
        }

        return "index";
    }

    /*@RequestMapping("/main")
    public ModelAndView main(){
        //创建ModelAndView对象,模型视图对象(模型数据+视图)
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");//设置逻辑视图名 ,默认跳转方式:转发
        mv.addObject("name","张三");//设值模型数据, 将数据设置在request域对象中
        return mv;
    }*/

    @RequestMapping("/main")
    public String main(Model model, HttpSession session){
        //假设未登录,需要重定向到登录页面
        //session.setAttribute("msg","用户名或密码错误"); 完成不同请求的数据共享
        //model.addAttribute("msg","用户名或密码错误");//将数据存放在request域对象中,如果类上添加了@SessionAttributes(value = "msg")注解,则该数据也会在session域对象中存放一份
        //return "redirect:login.jsp";//重定向,不会经过视图解析器
        //return "home";
        return "forward:home";//转发
    }


    @RequestMapping("/nothing")
    public void nothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("nothing...");

        //转发
        //request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);

        //重定向
        //response.sendRedirect("login.jsp");

        //直接页面输出
        response.getWriter().write("hello world");
    }


}
