package com.issac.diveinspringboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World 2018";
    }
}
