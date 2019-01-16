package com.issac.diveinspringboot.annotation;

import com.issac.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;

import java.lang.annotation.*;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorkdImportSelector.class)
public @interface EnableHelloWorld {
}
