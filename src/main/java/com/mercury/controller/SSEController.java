package com.mercury.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * 服务端推送技术
 * SSE server send Event 服务端发送事件
 * <p>
 * 媒体类型:text/event-stream
 */
@Controller
public class SSEController {

    private static final Logger logger = LoggerFactory.getLogger(SSEController.class);

    @RequestMapping(value = "/push", method = {RequestMethod.GET}, produces = {"text/event-stream"})
    @ResponseBody
    public String push() {
        Random random = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("thread sleep error:", e.getMessage());
        }
        logger.info("SSE push random:{}", random.nextInt());
        return "data:Testing 1,2,3 " + random.nextInt() + "\n\n";
    }
}
