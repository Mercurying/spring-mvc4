package com.mercury.controller;

import com.mercury.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/annotation/")
public class DemoAnnotationController {

    @RequestMapping(value = {"index"}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String index(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + "can access.";
    }

    @RequestMapping(value = {"object"}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String passObject(User user, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + "can access: user.id:" + user.getId() + " user.name:" + user.getName();
    }
}
