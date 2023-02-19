package com.kot.boot.test;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author yf
 * @create 2022-12-18 16:05
 */
@SpringBootTest
public class RedisTest {

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void testInsert(){
        redisTemplate.opsForValue().set("123","dot");
    }
}
