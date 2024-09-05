package com.kcc.rich.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

   // private String path = "C:\\Users\\KOSA\\Desktop\\abv\\";


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 로컬 파일을 불러오기 위한 경로 설정
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///");
    }
}
