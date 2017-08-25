/**
 * 
 */
package com.raintai.web.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 首页 Controller
 * 
 * @author 	alanwei
 * @since	2016-12-27
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	/**
	 * 跳转到首页
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) {
		System.out.println("index");
		request.getSession().setAttribute("parentMenu", "index");
		return "index";
	}
}
