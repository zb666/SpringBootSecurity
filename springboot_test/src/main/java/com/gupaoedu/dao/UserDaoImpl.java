package com.gupaoedu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public void insertUser() {
        System.out.println("---UserDao方法执行了----");
    }
}
