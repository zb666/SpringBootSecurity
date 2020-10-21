//package com.gupaoedu.service.impl;
//
//import com.gupaoedu.service.UserService;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class UserServiceImpl implements UserService {
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        // 模拟数据库操作 根据账号查询
//        String password = "$2a$10$9tzTU0L5cM7e25RPo.KGnOfzUzeulD0CzOoawooYSiUlrPABkCPXG";
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("User1"));
//        return null;
//    }
//}
