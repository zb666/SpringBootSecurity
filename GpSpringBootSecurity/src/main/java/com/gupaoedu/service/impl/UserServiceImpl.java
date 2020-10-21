package com.gupaoedu.service.impl;

import com.gupaoedu.service.IUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 模拟数据库操作 根据账号查询
        String password = "123456";
        // 假设查询出来的用户的角色
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("USER1"));
        UserDetails userDetails = new User(s,password,list);
        return userDetails;
    }
}
