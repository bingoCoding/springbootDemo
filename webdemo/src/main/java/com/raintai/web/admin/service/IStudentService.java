package com.raintai.web.admin.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface IStudentService {

	PageInfo getGeneralInfoData(Integer pageNum, Integer pageSize, String info);

	PageInfo getliveErrPushUserData(Integer pageNum, Integer pageSize, String userInfo);

	Map<String, Object> getliveErrPushUserSave(String studentAccount, String pushUserPhone, String pushUserName);

	Map<String, Object> getYuekeData(String startDay, String endDay);

	Map<String, Object> getStudentLessonInfo(String studentAccount);
	
	PageInfo getWorkData(Integer pageNum, Integer pageSize, String beginDate, String endDate, String userInfo);

	void updateManager(String managername, String managerphone);

	void saveRemark(String userphone, String msg);
}
