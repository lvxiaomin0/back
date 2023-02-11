package com.lvxiaomin.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/** 文件上传配置项
 * @Author: Ming
 * @Date: 2023/2/10 18:14
 */
@Configuration
public class MultipartThemeConfig {
    @Bean
    public MultipartConfigElement multipartConfig(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件大小200MB，单位KB,MB
        factory.setMaxFileSize(DataSize.parse("5MB"));
        //单个文件大小200MB，单位KB,MB
        factory.setMaxRequestSize(DataSize.parse("10MB"));
        return factory.createMultipartConfig();
    }
}
