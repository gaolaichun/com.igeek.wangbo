package com.igeek.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @create 2019/05/13
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if(user==null||user.equals("")){
            //未登录,重定向到登录页面
            response.sendRedirect(request.getServletContext().getContextPath()+"/user/toLogin");
            return false;
        }
        return true;
    }

}
