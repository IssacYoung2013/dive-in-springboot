package com.issac.diveinspringboot.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 二级 Repository {@link Repository}
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {

    String value() default "";
}
