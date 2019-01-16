package com.issac.diveinspringboot.bootstrap;

import com.issac.diveinspringboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBoostrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBoostrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld",String.class);

        System.out.println("helloWorld Bean: " + helloWorld);


        // 关闭上下文
        context.close();
    }
}
