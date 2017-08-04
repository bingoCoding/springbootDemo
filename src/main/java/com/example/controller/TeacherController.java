package com.example.controller;

import java.util.Map;

import javax.annotation.Resource;

import com.example.service.impl.TeacherService;
import com.example.utils.JSonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Value("${globleUrl}")
	private String url;

	@Resource
	private TeacherService teacherService;
	
	
	@RequestMapping(value="/queryClassByTeacherId/{teacherid}")
	public Map<String, Object> queryClassByTeacherId(@RequestParam(defaultValue="0") String state,@PathVariable String teacherid){
		String result=teacherService.queryClassByTeacherId(teacherid,state,url);
		return JSonUtil.fromJson(result, Object.class);
	}
}
