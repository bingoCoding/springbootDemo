package com.raintai.web.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.poi.hmef.attribute.MAPIAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.raintai.web.admin.dao.Pagination;
import com.raintai.web.admin.service.IOnlineClassroomService;

import net.sf.json.JSONObject;

/**
 * 在线教室
 * @author yan
 * 2017年7月21日 上午10:26:55 
 *
 */
@Controller
@RequestMapping("/onlineClassroom")
public class OnlineClassroomController {

	@Resource
	private IOnlineClassroomService iOnlineClassroomService;
	
	//购买课程人
	@RequestMapping(value = "/lessonBuy/index")
	public String gotoLessonBuyIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "lecturer");
		return "demo/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/lessonBuy/list")
	public Pagination<Object> getAccessLogListData( ) {
		
		return null;
	}
	
	//课表
	@RequestMapping(value = "/lecturerTimePlan/index")
	public String gotoLecturerTimePlanIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "course");
		return "onlineClassroom/lecturerTimePlan";
	}
	
	//课表
	@ResponseBody
	@RequestMapping(value = "/lecturerTimePlan/import")
	public String lecturerTimePlanImport(Part  file) {
		
		Map<String, Object> result=iOnlineClassroomService.lecturerTimePlanImport(file);
		return JSONObject.fromObject(result).toString();
	}
	
	//课表
	@ResponseBody
	@RequestMapping(value = "/lecturerTimePlan/data")
	public PageInfo getLecturerTimePlanData(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize
			,String beginDate,String endDate,String userInfo
			) {
		return iOnlineClassroomService.getLecturerTimePlanData(pageNum,pageSize,beginDate,endDate,userInfo);
	}
	
	//课表
	@ResponseBody
	@RequestMapping(value = "/lecturerTimePlan/delete")
	public Map<String, Object> deleteLecturerTimePlan(int id) {
		return iOnlineClassroomService.deleteLecturerTimePlan(id);
	}
	
	//课表
	@RequestMapping(value = "/lessonList/index")
	public String gotoLessonListIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "lesson");
		return "onlineLesson/lessonList";
	}
	//课表
	@ResponseBody
	@RequestMapping(value = "/lessonList/data")
	public PageInfo getLessonListData(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize,String beginDate,String endDate,String userInfo) {
		// 菜单设置
		return iOnlineClassroomService.getLessonListData(pageNum,pageSize,beginDate,endDate,userInfo);
	}
	
	//课表删除
	@ResponseBody
	@RequestMapping(value = "/lessonList/delete")
	public Map<String, Object> deleteLessonList(HttpServletRequest request,String roomNum) {
		// 菜单设置
		return iOnlineClassroomService.deleteLessonList(roomNum);
	}
	
	///授课课表
	@RequestMapping(value = "/onlineLessonGeneral/index")
	public String gotoOnlineLessonGeneralIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "onlineLesson");
		return "onlineLesson/onlineLessonGeneral";
	}
	//授课课表
	@ResponseBody
	@RequestMapping(value = "/onlineLessonGeneral/data")
	public PageInfo getOnlineLessonGeneralData(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize) {
		// 菜单设置
		return iOnlineClassroomService.getOnlineLessonGeneralData(pageNum,pageSize);
	}

	
	//修改课程发布情况
	@ResponseBody
	@RequestMapping(value = "/onlineLessonGeneral/updatePushStatus")
	public Map<String, Object> onlineLessonGeneralUpdatePushStatus(int detailsId,String pushStatus) {
		// 修改课程发布情况
		return iOnlineClassroomService.onlineLessonGeneralUpdatePushStatus(detailsId,pushStatus);
	}

	
	/**
	 * 保存课程包
	 * @param request 
	 * @param lessonName  课程名
	 * @param lessonMin 课程时长 
	 * @param lessonTypeId  课程类型   正课/试听
	 * @param lessonModeId 课程模式  陪练/授课
	 * @param lessonNum   课节
	 * @param money  课程价格
	 * @param onceMondey 单节价格
	 * @param lessonNo 课程编号
	 * @param targetPerson  适合水平
	 * @param description 课程描述
	 * @param teachingMode 授课模式
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineLessonGeneral/save")
	public Map<String, Object> saveOnlineLesson(HttpServletRequest request,String lessonName,int lessonMin,int lessonTypeId,int lessonModeId
				,int lessonNum,int money,int onceMondey,String lessonNo,String targetPerson,String description,String teachingMode,String equipment
			) {
		
		return iOnlineClassroomService.saveOnlineLesson(lessonName, lessonMin, lessonTypeId, lessonModeId, lessonNum, money, onceMondey, lessonNo, targetPerson, description, teachingMode,equipment);
	}

	
	///授课课表
	@RequestMapping(value = "/onlineLessonOrder/index")
	public String gotoOnlineLessonOrderIndex(HttpServletRequest request) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "onlineLesson");
		return "onlineLesson/onlineLessonOrder";
	}
	
	/**
	 * 获取订数据
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineLessonOrder/data")
	public PageInfo getOnlineLessonOrderlData(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize,String userInfo) {
		// 菜单设置
		return iOnlineClassroomService.getOnlineLessonOrderData(pageNum,pageSize,userInfo);
	}
	
	
	/**
	 * 获取课程包
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineLessonOrder/coursePacket")
	public Map<String, Object> getCoursePacket(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize) {
		// 菜单设置
		return iOnlineClassroomService.getCoursePacket();
	}

	/**
	 * 创建学生订单
	 * @param request
	 * @param studentAccount 学生账号
	 * @param buyMoney 购买金额
	 * @param coursePacketId 课程包
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineLessonOrder/createOrder")
	public Map<String, Object> createOrder(HttpServletRequest request,String studentAccount,int buyMoney,int coursePacketId) {
		// 菜单设置
		return iOnlineClassroomService.createOrder(studentAccount,buyMoney,coursePacketId);
	}
}
