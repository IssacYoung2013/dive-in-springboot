package com.issac.spring.boot.web.servlet;

import com.issac.spring.web.servlet.AsyncServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * author:  ywy
 * date:    2019-01-13
 * desc:
 */
@EnableAutoConfiguration
@ServletComponentScan(basePackages = "com.issac.spring.web.servlet")
public class SpringBootServletBoostrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletBoostrap.class);
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    ServletRegistrationBean asyncServletRegistrationBean() {
        return  new ServletRegistrationBean(new AsyncServlet(),"/async-servlet");
//        return new AsyncServlet();
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            FilterRegistration.Dynamic registration = servletContext.addFilter("filter",filter);
            registration.addMappingForUrlPatterns(EnumSet.of( DispatcherType.REQUEST),false,"/");
        };
    }

}
