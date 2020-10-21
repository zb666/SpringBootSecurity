package com.gupaoedu.config;

import com.gupaoedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin()
               .loginPage("/login.html")
               .loginProcessingUrl("/login.do")
               .and()
               .authorizeRequests()
               .antMatchers("/login.html")
               .permitAll()
               .anyRequest()
               .authenticated();
       http.csrf().disable();//禁止跨越攻击
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置自定义的账号密码
        auth.inMemoryAuthentication()
                .withUser("zhang")
                .password("123456")
                .roles("USER");
        // 关联自定义的认证的Service
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }

}
