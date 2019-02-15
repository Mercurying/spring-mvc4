package com.mercury.controller;

import com.mercury.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestNormalController {

    @Autowired
    private ITestService iTestService;

    @RequestMapping("/normal")
    public String testPage(Model model) {
        model.addAttribute("msg", iTestService.doSomething());
        return "page";
    }
}
