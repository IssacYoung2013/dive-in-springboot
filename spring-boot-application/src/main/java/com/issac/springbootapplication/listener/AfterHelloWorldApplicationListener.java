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
//@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent>,Ordered {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("After Hello World: " + event.getApplicationContext().getId() +
        ",timestamp:" + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
