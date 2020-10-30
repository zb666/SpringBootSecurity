package com.redis.test;

import com.gupao.redis.SpringBootTestApplication;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootTestApplication.class})
public class GpSpringDemoApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads(){
        redisTemplate.opsForValue().set("Bob","BobName");
        String bob = redisTemplate.opsForValue().get("Bob");
        System.out.println("RedisValue: "+bob);
    }



}
