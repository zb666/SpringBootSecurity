package com.redis.test;

import com.gupao.redis.SpringBootTestApplication;
import com.gupao.redis.bean.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootTestApplication.class})
public class GpSpringDemoApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void contextLoads(){
        String bob = redisTemplate.opsForValue().get("Bob");
        System.out.println("RedisValue: "+bob);
    }

    @Test
    public void testSerializable(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUserName("Zb666");
        userEntity.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("user",userEntity);
        UserEntity user = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
        if (user!=null){
            System.out.println(user.toString());
        }
    }


}
