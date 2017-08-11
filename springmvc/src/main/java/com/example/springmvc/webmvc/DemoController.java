package com.example.springmvc.webmvc;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class DemoController {

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("errormsg","abc");
        return "error2";
    }

    @RequestMapping("golobel")
    public String globel(@ModelAttribute("msg")String msg){
        throw new IllegalArgumentException("参数有误；；；；；＝"+"....msg"+msg);
    }
}
