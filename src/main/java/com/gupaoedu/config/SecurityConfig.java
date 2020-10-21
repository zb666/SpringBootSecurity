//package com.gupaoedu.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * 让每一个人的职业生涯不留遗憾
// *   SpringSecurity的配置类
// * @author 波波老师【咕泡学院】
// * @Description: ${todo}
// * @date 2020/7/29 10:30
// */
//@Configuration
//@EnableWebSecurity // 方法SpringSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    /**
//     * 认证的配置
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 配置自定义的账号密码
//        /*auth.inMemoryAuthentication()
//                .withUser("zhang")
//                .password("{noop}123")
//                .roles("USER");// 用户具有的角色*/
//        // 关联自定义的认证的Service
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123456"));
//    }
//
//    /**
//     * http请求的配置
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/login.html") // 指定自定义的登录界面
//                .loginProcessingUrl("/login.do") // 必须和登录表单的 action一致
//                .and()
//                .authorizeRequests() // 定义哪些资源被保护
//                .antMatchers("/login.html")
//                .permitAll() // login.html可以匿名访问
//                .anyRequest()
//                .authenticated(); //出来登录页面其他都需要认证
//        http.csrf().disable();// 禁用跨越攻击
//    }
//}
//
