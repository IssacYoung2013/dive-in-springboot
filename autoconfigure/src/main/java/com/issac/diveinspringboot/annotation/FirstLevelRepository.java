package com.issac.diveinspringboot.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 一级 {@link Repository @Repository}
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {

    String value() default "";
}
