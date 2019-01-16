package com.issac.web.config;

import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.File;

/**
 *
 * author:  ywy
 * date:    2019-01-06
 * desc: Spring MVC 配置的类
 */
@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);

        // 优先级高于 ThymeleafViewResolver
        // 配置ViewResolver 的 Content-Type
        viewResolver.setContentType("text/xml;charset=UTF-8");
        return viewResolver;
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {

        return (factory)->{
            factory.addContextCustomizers((context -> {
                // user.dir
                String relativePath = "springboot-view/src/main/webapp";
                File file = new File(relativePath);
                if(file.exists()) {
                    // 解决 Maven 多模块JSP无法读取的问题
                    context.setDocBase(file.getAbsolutePath());
                }
            }));
        };
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true);
        configurer.favorPathExtension(true);

    }

}
