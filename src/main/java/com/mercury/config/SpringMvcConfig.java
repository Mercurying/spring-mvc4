package com.mercury.config;


import com.mercury.interceptor.DemoInterceptor;
import com.mercury.messageConverter.CustomMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;


/**
 * 全局配置类
 * 使用java annotationConfig方式替代web.xml 启动spring容器
 * 配置视图解析器并启用webMvc注解
 */

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("com.mercury")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    // 视图解析器Bean
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/classes/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }

    // 静态资源映射配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler 对外暴露的路径    addResourceLocations文件放置位置
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    // 自定义interceptor拦截器
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    // 添加文件上传解析器
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(20971520); // 显示上传大小限制  20M=1024*1024*20
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }

    @Bean
    public CustomMessageConverter customMessageConverter() {
        return new CustomMessageConverter();
    }

    // extendMessageConverters 重写该方法不会覆盖默认注册的HttpMessageConverter bean
    // 添加自定义的customMessageConverter Bean实例
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }


    // 通过url定向到jsp页面 重新定向新的页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

    // url路径中不可忽略.以后的参数
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
