package com.kot.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yf
 * @create 2022-12-14 16:25
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
