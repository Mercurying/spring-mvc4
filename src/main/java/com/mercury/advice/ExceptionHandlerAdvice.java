package com.mercury.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


/**
 * 统一处理全局的配置信息
 *
 * @ControllerAdvice 控制器建言
 * @ExceptionHandler ：全局处理控制器里的异常信息
 * @InitBinder: 设置WebDataBinder 自动绑定前台请求参数到model中
 * @ModelAndAttribute: 绑定key-vale到model对象中 此处是让全局的@RequestMapping 获取此处设置的键值对数据
 */

@ControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(value = {Exception.class})
    public ModelAndView exception(Exception ex, WebRequest requst) {

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

}
