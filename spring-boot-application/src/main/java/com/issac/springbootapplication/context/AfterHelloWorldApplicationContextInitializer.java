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
public class AfterHelloWorldApplicationContextInitializer
        implements ApplicationContextInitializer,Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("After ConfigurableApplicationContext.id = " + applicationContext.getId());

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
