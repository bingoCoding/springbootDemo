package com.raintai.web.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.raintai.web.admin.dao.Pagination;
import com.raintai.web.admin.service.IOnlineClassroomService;
import com.raintai.web.admin.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private IStudentService iStudentService;
	
	/**
	 * 在线教室授课人
	 */
	@RequestMapping(value = "/onlineClassroom/lecturer/list")
	public String gotoAccessLogList(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "lecturer");
		return "demo/list";
	}

	
	/**
	 * 在线教室授课人集合
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineClassroom/lecturer/list/data")
	public Pagination<Object> getAccessLogListData( ) {
		
		return null;
	}
	
	
	/**
	 * 学生管理
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/generalInfo/index")
	public String gotoOnlineClassroomRoomInfoIndex(HttpServletRequest request,String roomNum) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "student");
		return "student/generalInfo";
	}
	
	
	/**
	 * 学生管理
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/generalInfo/data")
	public PageInfo getGeneralInfoData(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize,String userInfo) {
		return iStudentService.getGeneralInfoData(pageNum,pageSize,userInfo);
	}

	
	
	/**
	 * 在线课堂消息错误推送
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/liveErrPushUser/index")
	public String gotoLiveErrPushUserIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "student");
		return "student/liveErrPushUser";
	}
	
	/**
	 * 在线课堂消息错误推送 列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/liveErrPushUser/data")
	public PageInfo getliveErrPushUserData(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize,String userInfo) {
		return iStudentService.getliveErrPushUserData(pageNum,pageSize,userInfo);
	}

	
	/**
	 * 保存推送人列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/liveErrPushUser/save")
	public Map<String, Object> getliveErrPushUserSave(String studentAccount,String pushUserPhone,String pushUserName) {
		return iStudentService.getliveErrPushUserSave(studentAccount,pushUserPhone,pushUserName);
	}

	
	/**
	 * 在线课堂消息错误推送
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/studnetInfo/index")
	public String gotoStudentInfoIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "student");
		return "student/studentInfo";
	}
	
	
	/**
	 * 约课
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/yueke/index")
	public String gotoYuekeIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "student");
		return "student/yueke";
	}

	/**
	 * 约课
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/yueke/data")
	public Map<String, Object> getYuekeData(HttpServletRequest request,String startDay,String endDay) {
		// 菜单设置
		return iStudentService.getYuekeData(startDay,endDay);
	}
	
	/**
	 * 获取学生够课详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/studentLessonInfo")
	public Map<String, Object> getStudentLessonInfo(HttpServletRequest request,String studentAccount) {
		return iStudentService.getStudentLessonInfo(studentAccount);
	}
	
	/**
	 * 约课
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/workdesk/list")
	public String gotoWorkdeskList(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "student");
		return "student/workdeskList";
	}
	
	/**
	 * 工作台数据分页list
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/workdesk/listdata")
	public PageInfo getWorkData(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize,String beginDate,String endDate,String userInfo){
		return iStudentService.getWorkData(pageNum,pageSize,beginDate,endDate,userInfo);
	}


	/**
	 * 工作台 更新管理人
	 * @param managername
	 * @param managerphone
	 * @return
	 */
	@RequestMapping("/updateManager")
	@ResponseBody
	public String updateManager(@RequestParam(name = "managername",required = true) String managername,@RequestParam(name="managerphone",required = true) String managerphone){
		try{
			iStudentService.updateManager(managername,managerphone);
			return "ok";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}

	}

	/**
	 * 工作台 保存备注
	 * @param userphone
	 * @param msg
	 * @return
	 */
	@RequestMapping("/saveRemark")
	@ResponseBody
	public String saveRemark(@RequestParam(required = true) String userphone,@RequestParam String msg){
		try{
			iStudentService.saveRemark(userphone,msg);
			return "ok";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}

	}

}
