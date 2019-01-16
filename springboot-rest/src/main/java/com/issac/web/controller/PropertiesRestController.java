package com.issac.web.controller;

import com.issac.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * author:  ywy
 * date:    2019-01-11
 * desc:
 */
@Controller
public class PropertiesRestController {

    @PostMapping(value = "/add/properties",
            consumes = "text/properties;charset=UTF-8"// 过滤媒体类型
//            produces = "text/properties;charset=UTF-8"
    )
    public Properties properties(
//            @RequestBody
                                             Properties properties) {
        return properties;
    }

}
