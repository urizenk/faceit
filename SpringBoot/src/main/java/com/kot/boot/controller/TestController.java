package com.kot.boot.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yf
 * @create 2022-12-18 12:45
 */
@RestController
public class TestController {

    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/redis")
    public String addRedis(HttpServletRequest request){
        String key = request.getParameter("key");
        redisTemplate.opsForValue().set(key,"dot");
        return "ok";
    }

    @GetMapping("/redis")
    public String showRedis(){
        Object o = redisTemplate.opsForValue().get("123");
        assert o != null;
        return o.toString();
    }


}
