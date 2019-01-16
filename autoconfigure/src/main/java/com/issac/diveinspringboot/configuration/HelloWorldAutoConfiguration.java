package com.issac.diveinspringboot.configuration;

import com.issac.diveinspringboot.annotation.EnableHelloWorld;
import com.issac.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Configuration // Spring 模式注解
@EnableHelloWorld // Spring @Enable
@ConditionalOnSystemProperty(name = "user.name",value = "Issac")
public class HelloWorldAutoConfiguration {
}
