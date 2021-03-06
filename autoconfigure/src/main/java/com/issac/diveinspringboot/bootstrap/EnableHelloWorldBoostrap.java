package com.issac.diveinspringboot.bootstrap;

import com.issac.diveinspringboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@EnableHelloWorld
public class EnableHelloWorldBoostrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBoostrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld",String.class);

        System.out.println("helloWorld Bean: " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
