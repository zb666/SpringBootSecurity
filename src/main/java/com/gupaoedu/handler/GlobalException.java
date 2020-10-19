package com.gupaoedu.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView nullPoint(Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",ex.toString());
        modelAndView.setViewName("error1");
        return modelAndView;
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView arthException(Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",modelAndView);
        modelAndView.setViewName("error2");
        return modelAndView;
    }


}
