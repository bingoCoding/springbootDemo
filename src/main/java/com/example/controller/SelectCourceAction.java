package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.example.service.IOrgmsgService;
import com.example.utils.JSonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/selectCource")
public class SelectCourceAction {
	
	@Value("${globleUrl}")
	private String url;


	@Resource
	private IOrgmsgService orgmsgService;
	
	private String studentid;
	private String studentname;
	private String orgid;
	private String classid;
	private String classname;
	private String levelid;
	private String levelname;
	private String typeid;
	private String typename;
	private String periodid;
	private String classnum;
	private String timelimit;
	private int moneystatus = 0;//0.未缴费 1.已缴费
	private double realmoney=0.00;//实际缴费
	

	@RequestMapping("/addSelectCource")
	public Map<String, Object> addSelectCource() throws Exception {
		Map<String, Object> result=new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("selectCource.studentid", studentid);
		map.put("selectCource.studentname", studentname);
		map.put("selectCource.orgid", orgid);
		map.put("selectCource.classid", classid);
		map.put("selectCource.classname", classname);
		map.put("selectCource.levelid", levelid);
		map.put("selectCource.levelname", levelname);
		map.put("selectCource.typeid", typeid);
		map.put("selectCource.typename", typename);
		map.put("selectCource.periodid", periodid);
		map.put("selectCource.classnum", classnum);
		map.put("selectCource.timelimit", timelimit);
		map.put("selectCource.moneystatus", moneystatus);
		map.put("selectCource.realmoney", realmoney);
		String test=orgmsgService.addSelectCource(map,url);
		result.put("result", JSonUtil.fromJson(test, Object.class));
		return result;
	}
	
	
}
