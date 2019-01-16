package com.issac.spring.boot.web.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * author:  ywy
 * date:    2019-01-13
 * desc:
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SpringBootServletBoostrap.class);
        return builder;
    }

}
