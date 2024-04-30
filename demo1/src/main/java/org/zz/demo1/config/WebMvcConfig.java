package org.zz.demo1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zz.demo1.interceptor.MyInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").order(1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // META-INF/resources > resources > static > public 下的资源可以直接访问，源码中已经定义

        // 配置文件方式虽简单，但不够灵活，多个静态资源可能冲突
        // 自定义静态资源路径
        registry.addResourceHandler("/uploads/**").addResourceLocations("classpath:/uploads/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/front/");
    }
}
