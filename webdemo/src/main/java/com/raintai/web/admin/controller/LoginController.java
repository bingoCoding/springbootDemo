/**
 * 
 */
package com.raintai.web.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raintai.common.util.StringUtil;

/**
 * 登录 Controller
 * 
 * @author 	alanwei
 * @since	2016-12-27
 */
@Controller
public class LoginController {

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoLogin() {
		return "login";
	}
	
	/**
	 * 机构登录
	 * 
	 * @param request		请求
	 * @param userName		用户名
	 * @param password		密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, String userName, String password) {
		
		if (StringUtil.isEmpty(userName, password)) {
			return "login";
		}
		
		// 检测用户名密码
		if (!userName.equals("root") || !password.equals("admin")) {
			System.out.println("login");
			return "login";
		}
		return "redirect:/index";
	}
	
	/**
	 * 机构登出
	 * 
	 * @param request		请求
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "redirect:/";
	}
}
