package com.gupaoedu.service.impl;

import com.gupaoedu.service.IUserService;
import com.gupaoedu.dao.IUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public String query() {
        return "UserService 单元测试";
    }

    @Override
    public void insertUser() {
        userDao.insertUser();
    }

}
