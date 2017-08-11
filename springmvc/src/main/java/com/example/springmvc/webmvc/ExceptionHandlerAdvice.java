package com.example.springmvc.webmvc;

import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice 注解了@Controller的类的方法的全局配置
 * 可以将控制器的全局配置放在一起
 *
 * @ExceptionHandler 用于全局处理@Controller方法上的异常
 *
 * @ModelAttribute 让所有@RequestMapping方法都能访问到这里设置的model中的属性信息
 *
 * @InitBinder 自动绑定前台传的请求参数到model中
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * @ExceptionHandler 用于全局处理@Controller方法上的异常
     *                   value 可以过滤条件，此处拦截所有异常信息
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error2");
        modelAndView.addObject("errormsg",exception.getMessage());
        return modelAndView;
    }

    /**
     * @ModelAttribute 让所有@RequestMapping方法都能访问到这里设置的model中的属性信息
     * @param model
     */
    @ModelAttribute
    public void modelAttribute(Model model){
        model.addAttribute("msg","惊喜");
    }

    /**
     * @InitBinder 自动绑定前台传的请求参数到model中
     *              setDisallowedFields 此处忽略所有request里的id
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
