package com.gupaoedu.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    /**
     * 自定义全局异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof NullPointerException){
            modelAndView.setViewName("error1");
            modelAndView.addObject("error","空指针");
        }else if (e instanceof ArithmeticException){
            modelAndView.setViewName("error2");
            modelAndView.addObject("error","算数异常");
        }
        return modelAndView;
    }

}
