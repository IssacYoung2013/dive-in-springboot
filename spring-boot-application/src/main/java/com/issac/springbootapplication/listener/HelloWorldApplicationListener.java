package com.issac.springbootapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Hello World: " + event.getApplicationContext().getId() +
        ",timestamp:" + event.getTimestamp());
    }
}
