package com.issac.diveinspringboot.bootstrap;

import com.issac.diveinspringboot.configuration.HelloWorldConfiguration;
import com.issac.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@ComponentScan(basePackages = "com.issac.diveinspringboot.repository")
public class RepositoryBoostrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBoostrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

//         myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);


        System.out.println("myFirstLevelRepository Bean 是否存在 " + myFirstLevelRepository );


        // 关闭上下文
        context.close();
    }
}
