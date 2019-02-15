package com.mercury.service.impl;

import com.mercury.service.ITestService;
import org.springframework.stereotype.Service;

@Service("iTestService")
public class TestServiceImpl implements ITestService {
    @Override
    public String doSomething() {
        return "hello world";
    }
}
