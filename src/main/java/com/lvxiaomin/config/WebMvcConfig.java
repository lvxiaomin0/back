package com.lvxiaomin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // 设置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry
                .addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 设置是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求的方式
                .allowedMethods("GET","POST","DELETE","PUT")
                // 设置允许的header的属性
                .allowedHeaders("*")
                // 设置允许时间
                .maxAge(3600);
    }
}
