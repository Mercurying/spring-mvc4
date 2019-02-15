package com.mercury.controller;

import com.mercury.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestlController {

    @Autowired
    private ITestService iTestService;

    @RequestMapping(value = {"/testRest"}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String testPage() {
        return iTestService.doSomething();
    }
}
