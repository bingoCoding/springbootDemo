package com.example.springmvc.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecrityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()  //请求权限配置
//                .antMatchers("/","/login").permitAll() //匹配的路径全部允许通过
//                .anyRequest().authenticated()  //其他请求都需要认证后才能访问
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/tochat")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();

//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("role_admin")
//                .antMatchers("/user/**").hasAnyRole("role_user","role_admin")
//                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(1209600)//cookie有效期2个星期
                .key("user")//指定cookie中私钥
                .and()
                .logout()
                .logoutUrl("/logout")//注销URL
                .logoutSuccessUrl("logoutjsp")//注销成功跳转页面
                .permitAll();
    }

    /**
     * 内存中的用户
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("aaa").password("aaa").roles("USER")
//                .and()
//                .withUser("bbb").password("bbb").roles("USER");
//    }


    @Resource
    DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }
    /**
     * jdbc
     * @param auth
     * @throws Exception
     * jdbcAuthentication()默认定义了数据库表和字段
     * (1)采用默认： auth.jdbcAuthentication().dataSource(dataSource);
     * (2)jdbc自定义：auth.jdbcAuthentication()
     *                  .usersByUsernameQuery("select name,password,true from person where name=?")
     *                  .authoritiesByUsernameQuery("select name,role from roles where name=?");
     * (3)通用方法
     *      自定义实现UserDetailsService接口
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        默认
//        auth.jdbcAuthentication().dataSource(dataSource);
//        自定义
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery("select name,password,true from person where name=?")
//                .authoritiesByUsernameQuery("select name,role from roles where name=?");
//        通用自定义
        auth.userDetailsService(userDetailsService());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }

}
