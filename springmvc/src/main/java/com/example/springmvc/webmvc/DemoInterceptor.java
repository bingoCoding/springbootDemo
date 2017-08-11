package com.example.springmvc.webmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器  计算请求的的响应时间
 * 1.实现HandlerInterceptor接口
 * 2.extends HandlerInterceptorAdapter
 *
 */

public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long startime = System.currentTimeMillis();
        httpServletRequest.setAttribute("startime",startime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long endtime = System.currentTimeMillis();
        long startime = (long)httpServletRequest.getAttribute("startime");
        httpServletRequest.removeAttribute("startime");
        System.err.println("time = "+(endtime-startime));
        httpServletRequest.setAttribute("time",endtime-startime);
    }

}
