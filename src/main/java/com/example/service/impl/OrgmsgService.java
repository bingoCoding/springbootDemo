package com.example.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.service.IOrgmsgService;
import com.example.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class OrgmsgService implements IOrgmsgService {

//	@Value("${globleUrl}")
//	private String url;
	
	@Override
	public String queryOrgmsg(String orderby, Double lat, Double lng, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orderby", orderby);
		if(lat!=null&&lat>0) {
			map.put("lat", lat);
		}
		if(lng!=null&&lng>0) {
			map.put("lng", lng);
		}
		return HttpUtil.sendPost(url+"Action/zj/queryOrgmsg", map, false);
	}

	@Override
	public String queryOrgDetailInfo(String orgid, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orgid", orgid);
		return HttpUtil.sendPost(url+"Action/zj/queryOrgDetailInfo", map, false);
	}

	@Override
	public String queryClasspayForOnce(String classid, String levelid, String typeid, String periodid, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("classid", classid);
		map.put("levelid", levelid);
		map.put("typeid", typeid);
		map.put("periodid", periodid);
		return HttpUtil.sendPost(url+"Action/zj/queryClasspayForOnce", map, false);
	}

	@Override
	public String addSelectCource(Map<String, Object> map, String url) {
		return HttpUtil.sendPost(url+"Action/zj/addSelectCource", map, false);
	}

	
}
