package com.codegym.agoda.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**")
                .addResourceLocations("file:C:\\Users\\Media\\Desktop\\New folder (2)\\agoda\\src\\main\\resources\\upload\\" );

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/" );
    }
}