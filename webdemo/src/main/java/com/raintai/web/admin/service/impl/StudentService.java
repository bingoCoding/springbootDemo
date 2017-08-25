package com.raintai.web.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.raintai.web.admin.system.Content;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.raintai.common.util.MapUtil;
import com.raintai.web.admin.mapper.StudentMapper;
import com.raintai.web.admin.service.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Resource
	private StudentMapper studentMapper;

	@Override
	public PageInfo getGeneralInfoData(Integer pageNum, Integer pageSize, String userInfo) {
		PageHelper.startPage(pageNum, pageSize);
		if(userInfo!=null&&userInfo.trim().length()>0){
			userInfo="%"+userInfo.trim()+"%";
		}
		List<Map<String, Object>> list=studentMapper.getGeneralInfoData(userInfo);
		
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo getliveErrPushUserData(Integer pageNum, Integer pageSize, String userInfo) {
		PageHelper.startPage(pageNum, pageSize);
		if(userInfo!=null&&userInfo.trim().length()>0){
			userInfo="%"+userInfo.trim()+"%";
		}
		List<Map<String, Object>> list=studentMapper.getliveErrPushUserData(userInfo);
		
		return new PageInfo<>(list);
	}

	@Override
	public Map<String, Object> getliveErrPushUserSave(String studentAccount, String pushUserPhone,
			String pushUserName) {
		Map<String, Object> result=new HashMap<String, Object>();
		//判断有没有该学生
		Map<String, Object> map=studentMapper.getStudentInfoByAccount(studentAccount);
		if(map==null||studentAccount.isEmpty()){
			result.put("errMsg", "该学生账号不存在!");
			return result;
		}
		int studentId=Integer.parseInt(map.get("id")+"");
		int count=studentMapper.getPushCout(studentId,pushUserPhone);
		if(count==0){
			studentMapper.insertPushUser(studentAccount,studentId,pushUserPhone,pushUserName);
		}
		//判断有没有添加过
		
		
		return result;
	}

	@Override
	public Map<String, Object> getYuekeData(String startDay,String endDay) {
		Map<String, Object> result=new HashMap<>();
		List<Map<String, Object>> list=studentMapper.getLessonDayTime(startDay,endDay);
		
		List<Map<String, Object>> list1=studentMapper.getUserTeachingDayTime(startDay,endDay);
		//判断该时间段是否有课程
		for(Map<String, Object> m:list){
			String startTime=m.get("date_day").toString()+" "+m.get("start_time").toString()+":00";
			String endTime=m.get("date_day").toString()+" "+m.get("end_time").toString()+":00";
			List<Map<String, Object>> childList=null;
			if(m.get("childList")==null){
				childList=new ArrayList<>();
				m.put("childList", childList);
			}else{
				childList=(List<Map<String, Object>>) m.get("childList");
			}
			
			//判断该课程下是否有课 有老师
			for(Map<String, Object> m1:list1){
				String startTime1=m1.get("start_date")+"";
				String endTime1=m1.get("end_date")+"";
				if(endTime1.compareTo(startTime)>0&&startTime1.compareTo(endTime)<0){
					childList.add(MapUtil.copy(m1));
				}
			}
			
		}
		
		
		List<Map<String, Object>> resultList=new ArrayList<>();
		for(Map<String, Object> m :list){
			
			String start_time=m.get("start_time").toString();
			Map<String, Object> om=null;
			for(Map<String, Object> m1:resultList){
				String start_time1=m1.get("start_time").toString();
				if(start_time.equals(start_time1)){
					om=m1;
				}
			}
			
			List<Map<String, Object>> omList=null;
			if(om==null||om.isEmpty()){
				om=new HashMap<>();
				omList=new ArrayList<>();
				om.put("start_time", m.get("start_time").toString());
				om.put("list", omList);
				resultList.add(om);
			}else{
				omList=(List<Map<String, Object>>) om.get("list");
			}
			
			omList.add(MapUtil.copy(m));
			
		}
		
		result.put("list", resultList);
		return result;
	}

	@Override
	public Map<String, Object> getStudentLessonInfo(String studentAccount) {
		Map<String, Object> result=new HashMap<>();
		Map<String, Object> uMap=studentMapper.getStudentInfoByAccount(studentAccount);
		result.put("studentInfo", uMap);
		if(uMap!=null&&!uMap.isEmpty()){
			int sId=Integer.parseInt(uMap.get("id")+"");
			
		}
		
		return result;
	}

	@Override
	public PageInfo getWorkData(Integer pageNum, Integer pageSize, String beginDate, String endDate, String userInfo) {
		PageHelper.startPage(pageNum, pageSize);
		if(userInfo!=null&&userInfo.trim().length()>0){
			userInfo="%"+userInfo.trim()+"%";
		}
		List<Map<String, Object>> list=studentMapper.getWorkdeskData(beginDate,endDate,userInfo);
		for(Map<String, Object> map :list){
			if(Content.ACTIVITY_TYPE.containsKey(map.get("activity_type"))){
				map.put("activity_type",Content.ACTIVITY_TYPE.get(map.get("activity_type")));
			}
			if (Content.FROMSOURCE.containsKey(map.get("fromsource"))){
				map.put("fromsource",Content.FROMSOURCE.get(map.get("fromsource")));
			}
		}
		
		return new PageInfo<>(list);
	}

	@Override
	public void updateManager(String managername, String managerphone) {
		studentMapper.updateManager(managerphone);
		studentMapper.saveUserManager(managername,managerphone);
	}

	@Override
	public void saveRemark(String userphone, String msg) {
		studentMapper.saveRemark(userphone,msg);
	}
}
