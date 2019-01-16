package com.issac.springbootapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc: Spring 应用事件引导类
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件：" + event);
        });


        // 启动上下文
        context.refresh();

        // 发事件
        context.publishEvent("Hello World 2018");
        context.publishEvent("Hello World 2019");
        context.publishEvent(new ApplicationEvent("helloworld") {
            @Override
            public Object getSource() {
                return "Hello World";
            }

        });


        // 关闭上下文
        context.close();;
    }
}
