package com.example.springmvc.sse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * 服务器推送技术
 * 基于服务端发送技术
 * text/event-stream 服务端输出媒体类型，这是服务器端sse的支持
 *
 */
@Controller
@RequestMapping("/")
public class SseController {

    @RequestMapping(value = "push",produces = "text/event-stream")
    public String push(){
        Random n=new Random(100);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "随机数："+n.nextInt();
    }
}
