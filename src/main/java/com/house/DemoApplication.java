package com.house;

import com.house.Filter.LoginFilter;
import com.house.Filter.adminFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(value = "com.house.mapper")
@ServletComponentScan(value = "com.house.Filter")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    //添加后台防盗过滤器
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter( new adminFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/admin/*");
       return registration;
    }
    //添加前台防盗过滤器
    @Bean
    public FilterRegistrationBean someFilterRegistration2() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter( new LoginFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/page/*");
        return registration;
    }
}
