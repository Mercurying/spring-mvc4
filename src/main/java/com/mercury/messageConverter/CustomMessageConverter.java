package com.mercury.messageConverter;

import com.mercury.domain.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 自定义HttpMessageConverter类
 * 自定义媒体类型 application/mercury
 */

public class CustomMessageConverter extends AbstractHttpMessageConverter<User> {

    public CustomMessageConverter() {
        // 自定义媒体类型 application/mercury
        super(new MediaType("application", "mercury", Charset.forName("UTF-8")));
    }

    // 仅支持User类型
    @Override
    protected boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    // 目前只能处理形式 1-mercury 数据
    // 处理请求数据 处理由"-"进行分割开的数据 并将其转换成User类型
    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String tempArray[] = temp.split("-");
        return new User(Integer.valueOf(tempArray[0]), tempArray[1]);
    }

    // 处理输出数据到response中  返回成hello:+原数据形式
    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + user.getId() + "-" + user.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}
