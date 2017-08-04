package com.example.service.impl;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.filter.EmptyAspect;
import com.example.service.ITeacherService;
import com.example.utils.HttpUtil;
import com.example.utils.JSonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Service
public class TeacherService implements ITeacherService {

//	@Value("${globleUrl}")
//	private String url;


	public String queryClassByTeacherId(String teacherid, String state, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("teacherid", teacherid);
		map.put("state", state);
		return HttpUtil.sendPost(url+"Action/zj/queryClassByTeacherId", map, false);
	}

	@SuppressWarnings("unchecked")
	public String login(String username, String password, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		String loginstr = HttpUtil.sendPost(url+"Action/zj/loginapp", map, false);
		Map<String,Object> obj= JSonUtil.fromJson(loginstr, Map.class);
		if("0".equals(""+obj.get("result"))) {
			String id=""+obj.get("id");
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        Map<String,String> usermap = (Map<String,String>)request.getSession().getAttribute(EmptyAspect.USER_LOGIN_SESSION);
	        if(usermap==null) {
	        		usermap=new HashMap<String,String>();
	        }
	        usermap.put(username,new StringBuffer().append(password).append(id).toString());
	        request.getSession().setAttribute(EmptyAspect.USER_LOGIN_SESSION, usermap);
		}
		
		return loginstr;
	}
	
	

}
