package com.mercury.controller;

import com.mercury.service.IPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 测试异步方法 servlet
 */

@Controller
public class AsyncController {

    @Autowired
    private IPushService iPushService;

    @RequestMapping(value = {"/defer"}, method = RequestMethod.GET)
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return iPushService.getAsyncUpdate();
    }

}
