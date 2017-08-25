package com.raintai.web.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.raintai.web.admin.service.IOnlineClassroomService;

/**
 * 课程监控
 * @author yan
 * 2017年6月28日 下午12:35:39 
 *
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
	
	@Resource
	private IOnlineClassroomService iOnlineClassroomService;
	

	/**
	 * 在线教室监控
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/onlineClassroom/roomInfo/index")
	public String gotoOnlineClassroomRoomInfoIndex(HttpServletRequest request,String roomNum) {
		// 菜单设置
		request.getSession().setAttribute("parentMenu", "monitor");
		return "monitor/onlineClassroom/roomInfo";
	}
	
	/**
	 * 在线教室监控
	 * @param roomNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineClassroom/roomInfo/data")
	public Map<String, Object> getOnlineClassroomRoomInfoData(String roomNum) {
		return iOnlineClassroomService.getOnlineClassroomRoomInfoData(roomNum);
	}

	@GetMapping(value = "/onlineClassRoom/monitor")
	public String gotoOnlineClassRoomMonitor(HttpServletRequest request){
		request.getSession().setAttribute("parentMenu", "monitor");
		return "monitor/onlineClassroom/monitor";
	}

	/**
	 * 在线教室监控添加巡课建议
	 * @param roomNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onlineClassroom/roomInfo/addFeedback")
	public Map<String, Object> getOnlineClassroomRoomInfoFeedback(String roomNum,String content) {
		return iOnlineClassroomService.addOnlineClassroomRoomInfoFeedback(roomNum,content);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/online", method = RequestMethod.GET)
	public Map<String, Object> onlineClassRoom(@RequestParam("dateStr") String dateStr,
											   @RequestParam(value = "status", required = false) String status){
		try {
			return iOnlineClassroomService.getOnlineClassRoom(dateStr, status);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/online/info", method = RequestMethod.GET)
	public Map<String, Object> onlineClassRoomInfo(@RequestParam("roomNum") String roomNum){
		try {
			return iOnlineClassroomService.getOnlineClassRoomInfo(roomNum);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
