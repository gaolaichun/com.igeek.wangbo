package com.igeek.exception;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @create 2019/05/10
 * 全局异常处理器
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler 抛出异常的处理器
     * @param e 异常对象
     * @return 模型视图对象
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        ModelAndView mv = new ModelAndView();

        if(e instanceof  MyException){
            String message = e.getMessage();
            mv.addObject("msg",message);
            //记录日志
        }else{
            mv.addObject("msg","运行时异常==>"+e.getMessage());
            //记录日志
        }


        mv.setViewName("error");
        return mv;
    }
}
