package com.kot.boot.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author yf
 * @create 2022-12-18 16:05
 */
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testInsert(){
        redisTemplate.opsForValue().set("123","dot");
    }
}
