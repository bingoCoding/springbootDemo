package com.raintai.web.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raintai.web.admin.dao.Pagination;


@Controller
@RequestMapping("/demo")
public class DemoController {

	
	/**
	 * 跳转到访问日志列表页面
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String gotoAccessLogList(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "demo");
		return "demo/list";
	}

	
	/**
	 * 获取访问日志列表数据
	 * 
	 * @param vo			查询参数
	 */
	@ResponseBody
	@RequestMapping(value = "/list/data", method = RequestMethod.GET)
	public Pagination<Object> getAccessLogListData( ) {
		
		return null;
	}
}
