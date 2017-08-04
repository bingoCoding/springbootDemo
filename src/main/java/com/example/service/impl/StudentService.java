package com.example.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.service.IStudentService;
import com.example.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class StudentService implements IStudentService {

//	@Value("${globleUrl}")
//	private String url;

	public String queryClassByStudentId(String studentid, String state, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("studentid", studentid);
		map.put("state", state);
		return HttpUtil.sendPost(url+"Action/zj/queryClassByStudentId", map, false);
	}
	

}
