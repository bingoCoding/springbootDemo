package com.example.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.service.impl.TeacherService;
import com.example.utils.JSonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@RestController
@RequestMapping("/zj")
public class LoginController {

	@Value("${globleUrl}")
	private String url;

	@Resource
	private TeacherService teacherService;
	
	
	@RequestMapping(value="/loginapp")
	public Map<String, Object> queryClassByTeacherId(String username,String password){
		String result=teacherService.login(username,password,url);
		
		return JSonUtil.fromJson(result, Object.class);
	}
	@RequestMapping(value="/errorforword")
	public Map<String, Object> errorforword(){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
		return JSonUtil.fromJson(""+request.getAttribute("msg"), Object.class);
	}
}
