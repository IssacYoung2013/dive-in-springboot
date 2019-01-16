package com.issac.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * author:  ywy
 * date:    2019-01-07
 * desc:
 */
@SpringBootApplication(scanBasePackages = "com.issac.web")
public class SpringBootWebMvcBoostrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBoostrap.class);
    }
}
