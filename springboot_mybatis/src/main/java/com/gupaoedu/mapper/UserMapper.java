package com.gupaoedu.mapper;

import com.gupaoedu.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> query(User user);

    Integer addUser(User user);

    User queryById(Integer id);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);

}
