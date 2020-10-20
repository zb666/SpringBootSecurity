package com.gupaoedu.config;

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

/**
 * 让每一个人的职业生涯不留遗憾
 */
public class ShiroConfig extends AuthorizingRealm {

    @Autowired
    private IUserService service;

    /**
     * 认证的方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
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

    /**
     * 授权的方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        System.out.println("授权的账号是：" + user.getUsername());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("role1");
        return info;
    }
}
