package com.gupaoedu.mapper;

import com.gupaoedu.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> query(User user);

     Integer addUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
     User queryById(Integer id);

     Integer deleteUserById(Integer id);

     Integer updateUser(User user);
}
