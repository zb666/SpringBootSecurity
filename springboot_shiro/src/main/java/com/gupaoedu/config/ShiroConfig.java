package com.gupaoedu.config;

import com.gupaoedu.realm.AuthcRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    private String hashAlgorithName = "md5";

    private Integer hashIterations = 1024;

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(hashAlgorithName);
        matcher.setHashIterations(hashIterations);
        return matcher;
    }

    /**
     *  获取SecurityManager对象
     * @param realm
     * @return
     */
    @Bean
    //@DependsOn("authcRealm")
    public SecurityManager securityManager(AuthcRealm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    /**
     * 注册ShiroFilterFactoryBean
     * @param manager
     * @return
     */
    @Bean
    //@DependsOn("securityManager")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager){
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(manager);
        filter.setLoginUrl("/login.do");
        filter.setSuccessUrl("/success.html");
        filter.setUnauthorizedUrl("/refuse.html");
        // 设置过滤器链
        Map<String,String> map = new HashMap<>();
        map.put("/css/*","anon");
        map.put("/js/**","anon");
        map.put("/img/**","anon");
        map.put("/js/**","anon");
        map.put("/login","anon");
        map.put("/login.do","authc");
        map.put("/**","authc");
        filter.setFilterChainDefinitionMap(map);
        return filter;
    }

    /**
     * 开始Shiro 注解授权操作开始
     * @param manager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager manager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

}
