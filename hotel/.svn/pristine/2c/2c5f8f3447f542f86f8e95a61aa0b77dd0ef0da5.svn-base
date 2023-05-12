package org.soft.hotel.server.ctrl;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/deepblue/project/hotel/src/main/webapp/img/**").addResourceLocations("file:D:/deepblue/project/hotel/src/main/webapp/img/");
    }
}
