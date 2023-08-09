package com.example.korail.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new SessionAuthInterceptor());
        interceptorRegistration.addPathPatterns("/mypage**/**","/admin**/**","/reservation**/**");//체크해주세요

        //interceptorRegistration.excludePathPatterns();//체크에서 빼주세요
    }
}
