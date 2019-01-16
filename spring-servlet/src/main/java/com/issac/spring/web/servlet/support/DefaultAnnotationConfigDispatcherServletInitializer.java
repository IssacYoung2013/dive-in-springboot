package com.issac.spring.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * author:  ywy
 * date:    2019-01-07
 * desc:
 */
@ComponentScan(basePackages = "com.issac.spring.web.servlet.controller")
//@Configuration
public class DefaultAnnotationConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DiapatchServlet
        return new Class[]{getClass()};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
