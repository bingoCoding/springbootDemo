package com.example.service;

import java.util.Map;

public interface IOrgmsgService {

	String queryOrgmsg(String orderby, Double lat, Double lng, String url);

	String queryOrgDetailInfo(String orgid, String url);

	String queryClasspayForOnce(String classid, String levelid, String typeid, String periodid, String url);

	String addSelectCource(Map<String, Object> map, String url);

}
