package com.kot.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yf
 * @create 2022-12-17 21:57
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login(){
        //TODO 书写登录功能
        ModelAndView mav = new ModelAndView();
        return null;
    }

}
