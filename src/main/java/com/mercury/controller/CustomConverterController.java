package com.mercury.controller;

import com.mercury.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomConverterController {

    @RequestMapping(value = "/convert", produces = {"application/mercury"})
    @ResponseBody
    public User convert(@RequestBody User user) {
        return user;
    }
}
