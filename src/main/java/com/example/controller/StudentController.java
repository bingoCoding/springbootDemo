package com.example.controller;

import java.util.Map;

import javax.annotation.Resource;

import com.example.service.impl.StudentService;
import com.example.utils.JSonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Value("${globleUrl}")
	private String url;
	
	@Resource
	private StudentService studentService;
	
	
	@RequestMapping(value="/queryClassByStudentId/{studentid}")
	public Map<String, Object> queryClassByStudentId(@RequestParam(defaultValue="0") String state,@PathVariable String studentid){
		String result=studentService.queryClassByStudentId(studentid,state,url);
		return JSonUtil.fromJson(result, Object.class);
	}
}
