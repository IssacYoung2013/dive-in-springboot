package com.issac.springbootapplication.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
public class BeforeConfigFileApplicationListener implements  SmartApplicationListener,Ordered {


    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public int getOrder() { // 比 ConfigFileApplicationListener 优先级更高
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent)event;
            Environment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\")" + environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {

        }
    }

}
