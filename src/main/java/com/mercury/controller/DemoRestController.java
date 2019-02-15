package com.mercury.controller;

import com.mercury.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/")
public class DemoRestController {

    @RequestMapping(value = {"json"}, produces = {"application/json;charset=UTF-8"})
    public User json() {
        User user = new User(100, "json");
        return new User(user.getId(), user.getName());
    }

    @RequestMapping(value = {"xml"}, produces = {"application/xml;charset=UTF-8"})
    public User xml() {
        User user = new User(200, "xml");
        return new User(user.getId(), user.getName());
    }
}
