package com.mercury.service;

import org.springframework.web.context.request.async.DeferredResult;

public interface IPushService {
    DeferredResult<String> getAsyncUpdate();

    void refresh();
}
