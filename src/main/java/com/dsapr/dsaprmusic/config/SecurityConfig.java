package com.dsapr.dsaprmusic.config;

import com.dsapr.dsaprmusic.exception.RestAuthenticationEntryPoint;
import com.dsapr.dsaprmusic.filter.JwtAuthorizationFilter;
import com.dsapr.dsaprmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/17 12:48
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled= true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECRET = "DsaprMusic";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CREATE_TOKEN_URL = "/tokens";

    @Autowired
    UserService userService;
    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启跨域关闭csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, CREATE_TOKEN_URL).permitAll() // 暂时开放user请求
                .anyRequest().authenticated()
                .and()
//                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // 用户名密码鉴权
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userService)) // token 鉴权
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 将session改为无状态
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger**/**")//
                .antMatchers("/webjars/**")//
                .antMatchers("/v3/**")//
                .antMatchers("/doc.html")
                .antMatchers("/weixin/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
