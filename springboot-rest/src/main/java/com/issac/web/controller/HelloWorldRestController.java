package com.issac.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * author:  ywy
 * date:    2019-01-10
 * desc:
 */
@RestController
public class HelloWorldRestController {

    @GetMapping(value = "/hello-world")
    public String helloWorld(@RequestParam(required = false) String message) {
        return "HelloWorld " + message;
    }


//    @CrossOrigin
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
