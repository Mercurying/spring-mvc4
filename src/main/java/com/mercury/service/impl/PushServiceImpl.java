package com.mercury.service.impl;

import com.mercury.service.IPushService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service("iPushService")
public class PushServiceImpl implements IPushService {

    private DeferredResult<String> deferredResult;

    @Override
    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    // 以5秒为周期定时更新
    @Override
    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(String.valueOf(System.currentTimeMillis()));
        }
    }
}
