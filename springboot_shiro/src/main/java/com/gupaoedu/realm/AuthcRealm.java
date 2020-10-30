package com.gupaoedu.realm;

import com.gupaoedu.pojo.User;
import com.gupaoedu.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthcRealm extends AuthorizingRealm {

    @Autowired
    private IUserService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        System.out.println("开始认证: "+username);
        User user = new User();
        user.setUsername(username);
        // 根据账号认证
        List<User> list = service.query(user);
        if(list == null || list.size() != 1){
            // 账号不存在或者异常
            return  null;
        }
        user = list.get(0);
        return new SimpleAuthenticationInfo(user,user.getPassword(),new SimpleByteSource(user.getSalt()),"authcRealm");
    }
}
