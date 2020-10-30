package com.gupaoedu;

import com.gupaoedu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootTestApplication.class})
public class GpSpringDemoApplicationTests {

    @Resource
    private IUserService userService;

    @Test
    public void contextLoads(){
        System.out.println(userService.hashCode());
        userService.insertUser();
    }



}
