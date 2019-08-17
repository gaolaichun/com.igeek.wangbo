package com.igeek.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @create 2019/05/13
 */
public class MyInterceptor02 implements HandlerInterceptor {

    /**
     * 在handler(处理器)执行之前执行
     * 在此可以做一些权限控制\以及日志记录等
     * @param request
     * @param response
     * @param handler
     * @return false=>不放行 true=>执行处理器
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor02...preHandle...");
        return false;
    }

    /**
     * 在handler执行之后,并且视图返回之前执行
     * 在此可以修改视图
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor02...postHandle...");
        //modelAndView.setViewName("main"); 修改视图
    }

    /**
     * 在handler执行之后,并且视图返回结束之后
     * 在此可以实现一些异常的处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor02...afterCompletion...");
    }
}
