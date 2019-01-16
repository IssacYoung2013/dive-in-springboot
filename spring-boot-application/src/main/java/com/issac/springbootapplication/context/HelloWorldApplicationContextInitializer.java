package com.issac.springbootapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ConfigurableApplicationContext.id = " + applicationContext.getId());
    }
}
