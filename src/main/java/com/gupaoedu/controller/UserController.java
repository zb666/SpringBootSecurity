package com.gupaoedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg","Hello 22222");
        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int i = 0;
        int c = 100/i;
        return "success";
    }

    @RequestMapping("/showEmpty")
    public String showNullPoint(){
        String msg = null;
        msg.length();
        return "success";
    }

}
