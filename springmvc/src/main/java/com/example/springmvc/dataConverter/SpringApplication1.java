package com.example.springmvc.dataConverter;

import com.example.springmvc.webmvc.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * @EnableWebMvc 开启springmvc支持
 * 继承WebMvcConfigurerAdapter，重写方法完成对springmvc的配置
 * addResourceHandler指的是对外暴露的路径，addResourceLocations指的是资源的所在位置
 */
@Configuration
@EnableWebMvc
public class SpringApplication1 extends WebMvcConfigurerAdapter{


    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 静态资源映射
     * @param registry  f
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    /**
     * 添加注册拦截器
     * 相当于在web.xml添加<filter></filter>
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 添加固定路径跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("dataConverter");
    }

    /**
     * 路径匹配参数配置
     * eg:默认路径.后面的信息会忽略
     * configurer.setUseSuffixPatternMatch(false)之后
     * 路径中.后面的信息也会得到
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }


    /**
     *  configureMessageConverters会覆盖springmvc 里默认注册的多个HttpMessageConverter
     *  extendMessageConverters仅添加一个自定义的HttpMessageConverter，默认不会覆盖原来的
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.extendMessageConverters(converters);
        converters.add(converter());
    }
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//    }
    @Bean
    public DataConverter converter(){
        return new DataConverter();

    }



}
