package com.issac.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * author:  ywy
 * date:    2019-01-07
 * desc:
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("message")
    public String message() {
        return "Hello World";
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    @ModelAttribute("jessionId")
    public String jessionId(@CookieValue(value = "JSESSIONID",required = false) String jessionId) {
        return jessionId;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}


