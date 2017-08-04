package com.example.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.example.service.IOrgmsgService;
import com.example.utils.JSonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/orgmsg")
public class OrgmsgAction {
	
	@Value("${globleUrl}")
	private String url;

	@Resource
	private IOrgmsgService orgmsgService;
	
	
	@RequestMapping(value="/queryOrgmsg")
	public Map<String, Object> getTest(@RequestParam(defaultValue="distance") String orderby,Double lat,Double lng){
//		Map<String, Object> result=new HashMap<String, Object>();
		String test=orgmsgService.queryOrgmsg(orderby,lat,lng,url);
//		result.put("result", JSonUtil.fromJson(test, Object.class));
		return JSonUtil.fromJson(test, Object.class);
	}

	@RequestMapping("/queryOrgDetailInfo/{orgid}")
	public Map<String, Object> queryOrgDetailInfo(@PathVariable String orgid){
		Map<String, Object> result=new HashMap<String, Object>();
		String test=orgmsgService.queryOrgDetailInfo(orgid,url);
		result.put("result", JSonUtil.fromJson(test, Object.class));
		return result;
	}
	
	@RequestMapping("/queryClasspayForOnce")
	public Map<String, Object> queryClasspayForOnce(@RequestParam(required=true) String classid,@RequestParam(required=true) String levelid,@RequestParam(required=true) String typeid,@RequestParam(required=true) String periodid){
//		Map<String, Object> result=new HashMap<String, Object>();
		String test=orgmsgService.queryClasspayForOnce(classid,levelid,typeid,periodid,url);
//		result.put("result", JSonUtil.fromJson(test, Object.class));
		return JSonUtil.fromJson(test, Object.class);
	}
	
	
	
}
