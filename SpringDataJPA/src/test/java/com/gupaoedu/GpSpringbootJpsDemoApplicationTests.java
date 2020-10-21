package com.gupaoedu;

import com.gupaoedu.dao.UserRepository;
import com.gupaoedu.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GpSpringbootJpsDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads(){
        User user = new User();
        user.setName("gupao");
        user.setAge(4);
        userRepository.save(user);
    }

    @Test
    public void queryUser(){
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
