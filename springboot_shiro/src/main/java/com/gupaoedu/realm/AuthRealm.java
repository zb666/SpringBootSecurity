package com.gupaoedu.realm;

import com.gupaoedu.pojo.User;
import com.gupaoedu.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        System.out.println("授权账号："+user.getUsername());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("role1");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        System.out.println("开始认证：" + userName);
        User user = new User();
        user.setUsername(userName);
        // 根据账号认证
        List<User> list = service.query(user);
        if(list == null || list.size() != 1){
            // 账号不存在或者异常
            return  null;
        }
        user = list.get(0);
        return new SimpleAuthenticationInfo(user
                ,user.getPassword() // 密码
                ,new SimpleByteSource(user.getSalt()) // salt
                ,"authcRealm" // 自定义的Realm名称
        );
    }
}
