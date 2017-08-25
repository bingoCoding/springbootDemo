package com.example.springmvc.sse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class AsyncController {

    @Resource
    private PushService pushService;

    @RequestMapping("ayncSse")
    @ResponseBody
    public DeferredResult<String> asyncSse(){
        return pushService.getAsynMsg();
    }
}
