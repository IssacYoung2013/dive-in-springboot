package com.issac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * HelloWorld {@link Controller}
 *
 * @author ywy
 * @since 2018/1/6
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam int value, Model model) {
//        model.addAttribute("acceptLanguage", acceptLanguage);
//        model.addAttribute("jessionId", jessionId);
//        model.addAttribute("message","Hello,World");
        return "index";
    }

}
