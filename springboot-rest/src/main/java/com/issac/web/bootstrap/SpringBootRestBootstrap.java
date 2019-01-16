package com.issac.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author:  ywy
 * date:    2019-01-10
 * desc:
 */
@SpringBootApplication(scanBasePackages = {"com.issac.web.controller"
        , "com.issac.web.config"})
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class);
    }
}
