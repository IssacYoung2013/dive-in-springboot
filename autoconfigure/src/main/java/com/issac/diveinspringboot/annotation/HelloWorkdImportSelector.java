package com.issac.diveinspringboot.annotation;

import com.issac.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *  HelloWorld
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
public class HelloWorkdImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
