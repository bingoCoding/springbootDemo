package com.raintai.web.admin.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.github.pagehelper.PageInfo;

public interface IOnlineClassroomService {

	Map<String, Object> getOnlineClassroomRoomInfoData(String roomNum);

	Map<String, Object> getOnlineClassRoom(String dateStr, String status) throws Exception;

	Map<String, Object> getOnlineClassRoomInfo(String roomNum) throws Exception;

	Map<String, Object> addOnlineClassroomRoomInfoFeedback(String roomNum, String content);

	Map<String, Object> lecturerTimePlanImport(Part file);

	PageInfo getLecturerTimePlanData(int pageNum, int pageSize, String beginDate, String endDate, String userInfo);

	PageInfo getLessonListData(int pageNum, int pageSize, String startDay, String endDay, String userInfo);

	PageInfo getOnlineLessonGeneralData(Integer pageNum, Integer pageSize);
	
	Map<String, Object> saveOnlineLesson(String lessonName, int lessonMin, int lessonTypeId, int lessonModeId
            , int lessonNum, int money, int onceMondey, String lessonNo, String targetPerson, String description, String teachingMode, String equipment
    );

	PageInfo getOnlineLessonOrderData(Integer pageNum, Integer pageSize, String userInfo);

	Map<String, Object> deleteLessonList(String roomNum);

	Map<String, Object> deleteLecturerTimePlan(int id);

	Map<String, Object> onlineLessonGeneralUpdatePushStatus(int detailsId, String pushStatus);

	Map<String, Object> getCoursePacket();

	Map<String, Object> createOrder(String studentAccount, int buyMoney, int coursePacketId);
}
