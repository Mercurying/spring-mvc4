package com.mercury.controller;


import com.mercury.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/advice/")
@Controller
public class DemoAdviceController {

    @RequestMapping(value = {"index"}, method = {RequestMethod.GET})
    public String getSomething(@ModelAttribute("msg") String msg, User user) {
        throw new IllegalArgumentException("非常抱歉,程序出错了! 参数有误:/" + "来自@ModelAttribute:" + msg);
    }
}
