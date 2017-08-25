package com.example.springmvc.dataConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DataConverterController {

    @ResponseBody
    @RequestMapping(value = "converter",produces = "application/abc")
    public MyObj dataConverter(@RequestBody MyObj myObj){
        return myObj;
    }
}
