package com.issac.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link org.springframework.boot.SpringApplication}
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
//@SpringBootApplication
public class SpringApplicationBootStrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class);

        Set<String> sources = new HashSet<>();
        sources.add(ApplicationConfiguration.class.getName());

        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("Bean:" + context.getBean(ApplicationConfiguration.class));
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
