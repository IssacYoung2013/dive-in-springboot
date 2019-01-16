package com.issac.diveinspringboot.bootstrap;

import com.issac.diveinspringboot.condition.ConditionalOnSystemProperty;
import com.issac.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
//@ConditionalOnSystemProperty(name = "user.name",value = "issac")
public class ConditionalSystemPropertyBoostrap {


    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "Issac")
    public String helloWorld() {
        return "Hello World Issac";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalSystemPropertyBoostrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld",String.class);

        System.out.println("helloWorld Bean: " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
