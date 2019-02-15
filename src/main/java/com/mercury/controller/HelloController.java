package com.mercury.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello/")
public class HelloController {

    @RequestMapping(value = {"index", ""}, method = RequestMethod.GET)
    public String index() {

        return "index";  // 返回index.jsp页面
    }

}
