package com.fym.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String projectAbstractPath= "f:"+File.separator+"file/";
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/file/**").addResourceLocations("file:f:/file/");
    }





    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 置文件大小限制 ,超出此大小页面会抛出异常信息
        factory.setMaxFileSize("5MB"); //KB,MB
        // 设置总上传数据总大小
        factory.setMaxRequestSize("20MB");
        // 设置文件临时文件夹路径
        // factory.setLocation("E://test//");
        // 如果文件大于这个值，将以文件的形式存储，如果小于这个值文件将存储在内存中，默认为0
        // factory.setMaxRequestSize(0);
        return factory.createMultipartConfig();
    }

}
