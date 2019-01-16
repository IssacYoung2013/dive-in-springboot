package com.issac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * author:  ywy
 * date:    2019-01-11
 * desc:
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

}
