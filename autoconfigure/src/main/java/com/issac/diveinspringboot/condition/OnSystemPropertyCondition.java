package com.issac.diveinspringboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 *  系统属性 条件判断
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String,Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        String propertyName = String.valueOf(attributes.get("name"));

        String propertyValue = String.valueOf(attributes.get("value"));

        String javaPropertyValue = System.getProperty(propertyName);


        return propertyValue.equalsIgnoreCase(javaPropertyValue);
    }
}
