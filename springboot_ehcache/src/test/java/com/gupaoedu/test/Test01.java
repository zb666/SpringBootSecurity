package com.gupaoedu.test;

import com.gupaoedu.pojo.User;
import com.gupaoedu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class Test01 {

    @Autowired
    private IUserService userService;

    @Test
    public void test(){
        User user = userService.queryById(1);
        System.out.println(user);
        userService.queryById(1);
    }

}
