package com.issac.web.config;

import com.issac.web.http.method.PropertiesHandlerMethodArgumentResolver;
import com.issac.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.issac.web.http.method.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * author:  ywy
 * date:    2019-01-11
 * desc:
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        // 获取当前所有的resolvers
        List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolvers  = new ArrayList<>(resolvers.size() + 1);

        // 添加首位
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        newResolvers.addAll(resolvers);
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);

        List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(handlers.size() + 1);

        newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        newHandlers.addAll(handlers);
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 不建议添加到 converters 的末尾
//        converters.add(new PropertiesHttpMessageConverter());

        // 添加首位
//        converters.set(0, new PropertiesHttpMessageConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 添加自定义 HandlerMethodArgumentResolver  优先级低于 内建  HandlerMethodArgumentResolver
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}
