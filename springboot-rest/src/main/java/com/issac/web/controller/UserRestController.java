package com.issac.web.controller;

import com.issac.web.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * author:  ywy
 * date:    2019-01-11
 * desc:
 */
@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user",
            consumes = "application/*;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public User user(@RequestBody User user) {
        return user;
    }

}
