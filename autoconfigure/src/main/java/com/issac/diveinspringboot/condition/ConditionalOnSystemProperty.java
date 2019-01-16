package com.issac.diveinspringboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Java 系统属性 条件判断
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * Java 系统属性名称
     * @return
     */
    String name() default "issac";

    /**
     * Java 系统属性值
     * @return
     */
    String value() default "issac";
}
