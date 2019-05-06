package com.java.springboot04webrestfulcrud.config;

import com.java.springboot04webrestfulcrud.component.MyLocaleResolver;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 浏览器发送 /java 也来到/success请求
        registry.addViewController("/java").setViewName("success");
//        registry.addViewController("/java/**").setViewName("success");
    }
    // 视图控制，拦截路径转发到哪
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        System.out.println("ok?");
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("login");
                    registry.addViewController("/index.html").setViewName("login");
                    registry.addViewController("/main.html").setViewName("dashboard");
            }
        };

        return  adapter;
    }

    // 切换国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
