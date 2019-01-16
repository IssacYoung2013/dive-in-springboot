package com.issac.web.servlet.support;

import com.issac.web.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * author:  ywy
 * date:    2019-01-07
 * desc:
 */
public class DefaultAnnotationConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DiapatchServlet
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
