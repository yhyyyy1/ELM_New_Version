package com.neusoft.elmboot.config;

import com.neusoft.elmboot.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user", "/cart", "/deliveryAddress", "/orders", "/point", "/virtualWallet")
                .excludePathPatterns("/business", "/food", "/user/register", "/user/login");
    }
}
