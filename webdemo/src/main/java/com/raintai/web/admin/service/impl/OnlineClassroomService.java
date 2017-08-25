package com.raintai.web.admin.service.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Part;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.chainsaw.Main;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.raintai.common.util.DateUtil;
import com.raintai.web.admin.mapper.OnlineClassroomMapper;
import com.raintai.web.admin.service.IOnlineClassroomService;

@Service
public class OnlineClassroomService implements IOnlineClassroomService{
	
	private static final Logger LOG = LoggerFactory.getLogger(OnlineClassroomService.class);

	@Resource
	private OnlineClassroomMapper onlineClassroomMapper;
	
	@Override
	public Map<String, Object> getOnlineClassroomRoomInfoData(String roomNum) {
		Map<String, Object> result=new HashMap<>();
		
		int lesson_status=0;
		Map<String, Object> roomInfo=onlineClassroomMapper.getUserTeacherInfo(roomNum);
		if(roomInfo==null||roomInfo.isEmpty()){
			return result;
		}
		if(System.currentTimeMillis()<DateUtil.convertToDateTime(roomInfo.get("lesson_start_date")+"").getTime()){
			lesson_status=1;//未开课
		}
		
		
		
		result.put("video_url", roomInfo.get("video_url")); //视频url
		
		result.put("student_camera_video_url", roomInfo.get("student_camera_video_url")); //学生摄像头视频
		result.put("student_pad_video_url", roomInfo.get("student_pad_video_url")); //学生pad视频
		result.put("teacher_camera_video_url", roomInfo.get("teacher_camera_video_url")); //老师摄像头视频
		result.put("teacher_pad_video_url", roomInfo.get("teacher_pad_video_url")); //老师pad 视频
		result.put("lecturer", roomInfo.get("real_name"));//老师名称(授课人)
		result.put("student_real_name", roomInfo.get("student_real_name"));//学生名
		result.put("lesson_start_date", roomInfo.get("lesson_start_date"));//预约上课时间
		result.put("lesson_end_date", roomInfo.get("lesson_end_date")); //预约结束时间
		result.put("lesson_min", getDatePoor(DateUtil.convertToDateTime(roomInfo.get("lesson_end_date")+""), DateUtil.convertToDateTime(roomInfo.get("lesson_start_date")+"")));
		
		//添加巡课内容
		result.put("feedbackList",onlineClassroomMapper.getFeedback(roomNum));
		
		//学生操作日期
		Map<String, Object> studentRoomMsgInfo=onlineClassroomMapper.getRoomMsgInfo(roomNum,"s");
		studentRoomMsgInfo=(studentRoomMsgInfo==null||studentRoomMsgInfo.isEmpty())?new HashMap<>():studentRoomMsgInfo;
		if(studentRoomMsgInfo!=null&&!studentRoomMsgInfo.isEmpty()){
			result.put("student_start_op_time",studentRoomMsgInfo.get("start_op_time"));
			result.put("student_end_op_time",studentRoomMsgInfo.get("end_op_time"));
		}
			
		//授课人操作日期
		Map<String, Object> lecturerRoomMsgInfo=onlineClassroomMapper.getRoomMsgInfo(roomNum,"t");
		lecturerRoomMsgInfo=(lecturerRoomMsgInfo==null||lecturerRoomMsgInfo.isEmpty())?new HashMap<>():lecturerRoomMsgInfo;
		if(lecturerRoomMsgInfo!=null&&!lecturerRoomMsgInfo.isEmpty()){
			result.put("lecturer_start_op_time",lecturerRoomMsgInfo.get("start_op_time"));
			result.put("lecturer_end_op_time",lecturerRoomMsgInfo.get("end_op_time"));
		}	
		
		if(System.currentTimeMillis()>=DateUtil.convertToDateTime(roomInfo.get("lesson_start_date")+"").getTime()
				&&DateUtil.convertToDateTime(roomInfo.get("lesson_end_date")+"").getTime()>=System.currentTimeMillis()
				){
			if(studentRoomMsgInfo.get("start_op_time") !=null||studentRoomMsgInfo.get("end_op_time")!=null
					||lecturerRoomMsgInfo.get("start_op_time") !=null||lecturerRoomMsgInfo.get("end_op_time")!=null
					){//正在上课
				lesson_status=2;
			}
			
		}
		
		if(DateUtil.convertToDateTime(roomInfo.get("lesson_end_date")+"").getTime()<System.currentTimeMillis()){
			if(studentRoomMsgInfo.get("start_op_time") !=null&&lecturerRoomMsgInfo.get("start_op_time")!=null){//已结束 上过课
				lesson_status=3;
			}
			
			if(studentRoomMsgInfo.get("start_op_time") ==null||lecturerRoomMsgInfo.get("start_op_time")==null){//已结束 未上课
				lesson_status=4;
			}
		}
		
		
		//授课人app版本信息
		Map<String, Object> lectureAppInfo=onlineClassroomMapper.getUserAppInfo(Integer.parseInt(roomInfo.get("user_from_id")+"")+"",roomNum,"t");
		if(lectureAppInfo!=null&&!lectureAppInfo.isEmpty()){
			result.put("lecturer_app_version", lectureAppInfo.get("app_version"));
			result.put("lecturer_os_type", lectureAppInfo.get("os_type"));
			result.put("lecturer_device_type", lectureAppInfo.get("device_type"));
			result.put("lecturer_os_version", lectureAppInfo.get("os_version"));
		}

		//学生app版本信息
		Map<String, Object> studentAppInfo=onlineClassroomMapper.getUserAppInfo(Integer.parseInt(roomInfo.get("user_to_id")+"")+"",roomNum,"s");
		if(studentAppInfo!=null&&!studentAppInfo.isEmpty()){
			result.put("student_app_version", null != studentAppInfo.get("app_version")?studentAppInfo.get("app_version"):"");
			result.put("student_os_type", null !=lectureAppInfo && null != lectureAppInfo.get("os_type")?lectureAppInfo.get("os_type"):"");
			result.put("student_device_type", null !=lectureAppInfo && null != lectureAppInfo.get("device_type")?lectureAppInfo.get("device_type"):"");
			result.put("student_os_version", null !=lectureAppInfo && null != lectureAppInfo.get("os_version")?lectureAppInfo.get("os_version"):"");
		}
		
		//授课人平均值 速度
		Map<String, Object> lecturerAvgNetInfo=onlineClassroomMapper.getUserAvgNet(Integer.parseInt(roomInfo.get("user_from_id")+""));
		if(lecturerAvgNetInfo!=null&&!lecturerAvgNetInfo.isEmpty()){
			result.put("lecturer_avg_tx_quality", lecturerAvgNetInfo.get("avg_tx_quality"));
			result.put("lecturer_avg_rx_quality", lecturerAvgNetInfo.get("avg_rx_quality"));
		}
		//学生人平均值 速度
		Map<String, Object> studentAvgNetInfo=onlineClassroomMapper.getUserAvgNet(Integer.parseInt(roomInfo.get("user_to_id")+""));
		if(studentAvgNetInfo!=null&&!studentAvgNetInfo.isEmpty()){
			result.put("student_avg_tx_quality", studentAvgNetInfo.get("avg_tx_quality"));
			result.put("student_avg_rx_quality", studentAvgNetInfo.get("avg_rx_quality"));
		}
		
		
		Map<String, Object> studentNowNetInfo=onlineClassroomMapper.getNowNet(Integer.parseInt(roomInfo.get("user_to_id")+""));
		if(studentNowNetInfo!=null&&!studentNowNetInfo.isEmpty()){
			result.put("student_tx_quality", studentNowNetInfo.get("tx_quality"));
			result.put("student_rx_quality", studentNowNetInfo.get("rx_quality"));
		}
		
		Map<String, Object> lecturerNowNetInfo=onlineClassroomMapper.getNowNet(Integer.parseInt(roomInfo.get("user_from_id")+""));
		if(lecturerNowNetInfo!=null&&!lecturerNowNetInfo.isEmpty()){
			result.put("lecturer_tx_quality", lecturerNowNetInfo.get("tx_quality"));
			result.put("lecturer_rx_quality", lecturerNowNetInfo.get("rx_quality"));
		}
		
		
		result.put("actionList", onlineClassroomMapper.getUserActionList(roomNum));
		result.put("lesson_status", lesson_status);
		return result;
	}
	
	
	
	private static int getDatePoor(Date endDate, Date nowDate) {
		 
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    return  +Integer.parseInt(day*12*60+hour*60+min+"") ;
	}

	@Override
	public Map<String, Object> getOnlineClassRoom(String dateStr, String checkStatus) throws Exception{
		Map<String, Object> reValue = new HashMap<>(2);
		List<Map<String, Object>> classRooms = onlineClassroomMapper.getMonitorClassRoomData(dateStr);
		if(null != classRooms && classRooms.size() > 0){//0等待,1老师未进入,2学生未进入,3正常,4完成,5旷课,6迟到
			Map<String, List<Map<String, Object>>> times = new LinkedHashMap<>();
			Map<String, Object> room = null;
			List<Map<String, Object>> rooms = null;
			String time = null, status = null, roomNum = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int count = 0;
			for(Map<String, Object> entry: classRooms){
				time = entry.get("startTime").toString();
				status = entry.get("status").toString();
				roomNum = entry.get("roomNum").toString();
				room = new HashMap<>(2);
				room.put("roomNum", roomNum);
				room.put("status", status);
				if(!"0".equals(status)){
					Date startTime = sdf.parse(entry.get("start_date").toString());
					List<Map<String, Object>> tmp = onlineClassroomMapper.getClassRoomAction(roomNum);
					if(null != tmp && tmp.size() > 0){
						boolean tStatus = false, sStatus = false, dely = false;
						for(Map<String, Object> tmpEn:tmp){
							if("in".equals(tmpEn.get("action_name").toString())){
								if("s".equals(tmpEn.get("role_name").toString())){
									sStatus = true;
								}else if("t".equals(tmpEn.get("role_name").toString())){
									tStatus = true;
								}
								dely = dely || startTime.before(sdf.parse(tmpEn.get("op_time").toString()));
							}else if("out".equals(tmpEn.get("action_name").toString())){
								room.put("status", "4");
							}
						}
						if("on".equals(status)){
							if(sStatus && tStatus){
								room.put("status", dely?"6":"3");//6迟到
							}else if(!sStatus){
								room.put("status", "2");
							}else if(!tStatus){
								room.put("status", "1");
							}
						}else{
							room.put("status", "4");
						}
					}else{
						if("on".equals(status)){
							room.put("status", "6");
						}else{
							room.put("status", "5");
						}
					}
				}
				if(null != checkStatus && !"".equals(checkStatus)) {
					if (times.containsKey(time)) {
						if (checkStatus.indexOf(room.get("status").toString() + ",") > -1) {
							times.get(time).add(room);
							count++;
						}
					} else {
						if (checkStatus.indexOf(room.get("status").toString() + ",") > -1) {
							rooms = new ArrayList<>();
							rooms.add(room);
							count++;
							times.put(time, rooms);
						}
					}
				}else{
					if (times.containsKey(time)) {
						times.get(time).add(room);
						count++;
					} else {
						rooms = new ArrayList<>();
						rooms.add(room);
						count++;
						times.put(time, rooms);
					}
				}
			}
			reValue.put("datas", times);
			reValue.put("count", count);
		}
		return reValue;
	}

	@Override
	public Map<String, Object> getOnlineClassRoomInfo(String roomNum) throws Exception {
		return onlineClassroomMapper.getClassRoomInfo(roomNum);
	}



	@Override
	public Map<String, Object> addOnlineClassroomRoomInfoFeedback(String roomNum, String content) {
		onlineClassroomMapper.addOnlineClassroomRoomInfoFeedback(roomNum,content);
		return new HashMap<>();
	}



	@Override
	public Map<String, Object> lecturerTimePlanImport(Part file) {
		Map<String, Object> result=new HashMap<>();
		Workbook workbook = null;
		try{
		
			workbook = new XSSFWorkbook(file.getInputStream());
		}catch (Exception e) {
			System.out.println(e);
			
			try {
				workbook = new HSSFWorkbook(file.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(null == workbook){
			result.put("error", "请上传文件");
			
		}

		Sheet sheet = workbook.getSheetAt(0);
		if(null == sheet){
			result.put("error", "没有可用的sheet文件");
			
		}
		
		Row row = null;
		int rowCount = 1;
		Integer lastRow = sheet.getLastRowNum();
		if(lastRow < rowCount){
			result.put("error", "文件无内容");
		}
		StringBuffer bf=new StringBuffer();
		List<Map<String, Object>> list=new ArrayList<>();
		for(int i = 1; i<= lastRow; i++){
			Map<String, Object> m=new HashMap<>();
			String error="";
			row = sheet.getRow(i);
			if(null == row.getCell(0) || StringUtils.isEmpty(row.getCell(0)+""))
				continue;
			String phone=checkRowString(row.getCell(0));//电话
			String name=(row.getCell(1)+"").trim();//姓名
			String day=(row.getCell(2)+"").trim();//日期
			String startHour=(row.getCell(3)+"").trim();//开始时间
			String endHour=(row.getCell(4)+"").trim();//结束时间
			String isDelete=(row.getCell(5)+"").trim();//是否删除
			m.put("day", day);
			m.put("startHour", startHour);
			m.put("endHour", endHour);
			
			//判断手机号是否存在
			Map<String, Object> user= onlineClassroomMapper.getUserByPhone(phone);
			if(user==null||user.isEmpty()){
				error+=" 账号:"+phone+" 不存在";
			}else{
				m.put("userId", user.get("id"));
			}
			
			//判断该手机号是否存在
			if(day.trim().length()!=10){
				if(!isTimeLegal(day+" 00:00:00")){
					error+=" 日期:"+day.trim()+" 错误";
				}
			}
			if(startHour.trim().length()!=5){
				//开始时间有问题
				if(!isTimeLegal(day+" "+startHour+":00")){
					error+=" 开始时间:"+startHour.trim()+" 错误";
				}
			}
			if(endHour.trim().length()!=5){
				//开始时间有问题
				if(!isTimeLegal(day+" "+endHour+":00")){
					error+=" 结束时间:"+startHour.trim()+" 错误";
				}
			}
			
			if(isDelete.trim().length()!=1){
				error+=" 是否删除:"+isDelete.trim()+" 错误";
			}
			
			
			if(!error.equals("")){
				bf.append(" 第"+(i+1)+"行" +error+" <br>");
			}
			LOG.info("导入数据: 电话:"+phone+" 名称:"+name+" 日期："+day+" 开始时间:"+startHour+" 结束时间:"+endHour);
			
			if(isDelete.trim().equals("是")){
				onlineClassroomMapper.deleteLecturerTimePlan(Integer.parseInt(m.get("userId")+""),m.get("day")+"");
			}else{
				list.add(m);
			}
			
		}
		
		System.out.println(bf.toString());
		
		
		if(bf==null||"".equals(bf.toString().trim())){
			//批量添加
			for(Map<String, Object> m:list){
				//判断该人该天是否存在
			    Integer id=onlineClassroomMapper.getLecturerTimePlanId(Integer.parseInt(m.get("userId")+""),m.get("day")+"");
				if(id==null||id==0){
					
					onlineClassroomMapper.insertLecturerTimePlan(m);
				}else{
					m.put("id", id);
					onlineClassroomMapper.updateLecturerTimePlan(m);
				}
			}
			
		}else{
			result.put("lineError", bf.toString());
		}
		
		
		return result;
	}
	
	/**
	 * 时间正则表达式
	 * @param patternString
	 * @return
	 */
    public static boolean isTimeLegal(String patternString) {  
        if(patternString==null||patternString.trim().length()==0){
        	return false;
        }
        if(!patternString.contains(":")){
        	return false;
        }
        
        Pattern a=Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");   
        Matcher b=a.matcher(patternString);   
        if(b.matches()) {  
              return true;  
        } else {  
              return false;  
        }  
   }



	@Override
	public PageInfo getLecturerTimePlanData(int pageNum,int pageSize,String beginDate,String endDate,String userInfo) {
		
		PageHelper.startPage(pageNum, pageSize);
		if(userInfo!=null&&userInfo.trim().length()>0){
			userInfo="%"+userInfo.trim()+"%";
		}
		List<Map<String, Object>> list=onlineClassroomMapper.getLecturerTimePlanData(beginDate,endDate,userInfo);
		
		return new PageInfo<>(list);
	}
    
	
	/**
	 * 判断列的属性
	 */
	public static String checkRowString(Cell cell){
		if(cell!=null){
	
				
				if(cell.getCellType()==Cell.CELL_TYPE_STRING){
					return cell.getStringCellValue();
				}
				if(cell.getCellType()== Cell.CELL_TYPE_NUMERIC){
					if(HSSFDateUtil.isCellDateFormatted(cell)){
					  return cell.getDateCellValue()+"";
					}else{
						DecimalFormat df = new DecimalFormat("0");
						String str= df.format(cell.getNumericCellValue());
						return str;
					}
					
				}
				if(cell.getCellType()==Cell.CELL_TYPE_FORMULA){
					return cell.getCellFormula()+"";
				}
				if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
					return cell.getBooleanCellValue()+"";
				}

				
		}else {
			return null;
		}
		return null;
	}



	@Override
	public PageInfo getLessonListData(int pageNum,int pageSize,String startDay, String endDay, String userInfo) {
		
		PageHelper.startPage(pageNum, pageSize);
		if(userInfo!=null&&userInfo.trim().length()>0){
			userInfo="%"+userInfo.trim()+"%";
		}
		List<Map<String, Object>> list=onlineClassroomMapper.getLessonListData(startDay,endDay,userInfo);
		for(Map<String, Object> m:list){
			m.put("yuyueSongs", onlineClassroomMapper.getYuyueSongList(m.get("room_num")+""));
		}
		
		return new PageInfo<>(list);
	}



	@Override
	public PageInfo getOnlineLessonGeneralData(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list=onlineClassroomMapper.getOnlineLessonGeneralData();
		
		return new PageInfo<>(list);
	}


	@Transactional
	@Override
	public Map<String, Object> saveOnlineLesson(String lessonName, int lessonMin, int lessonTypeId, int lessonModeId,
			int lessonNum, int money, int onceMondey, String lessonNo, String targetPerson, String description,
			String teachingMode,String equipment) {
		Map<String, Object> p1=new HashMap<>();
		p1.put("id",0 );
		p1.put("name",lessonName );
		p1.put("lesson_min", lessonMin);
		p1.put("show_status", "2");
		p1.put("target_person", targetPerson);
		p1.put("description",description );
		p1.put("remark",description );
		p1.put("lesson_type_id", lessonTypeId);
		p1.put("lesson_mode_id",lessonModeId );
		p1.put("modify_date",new Date());
		
		if(lessonTypeId==1){
			p1.put("type_name","试听课" );
			p1.put("app_show","0" );//试听课app不显示
		}else{
			p1.put("type_name","陪练课" );
			p1.put("app_show","1" );//陪练课app显示
		}
		
		onlineClassroomMapper.saveOnlineLesson(p1);
		Map<String, Object> p2=new HashMap<>();
		p2.put("id", 0);
		p2.put("online_lesson_general_id", p1.get("id"));
		p2.put("lesson_num",lessonNum );
		p2.put("money",money );
		p2.put("once_mondey",onceMondey );
		p2.put("show_status", "2");
		p2.put("real_price", money);
		p2.put("lesson_no",lessonNo );
		p2.put("modify_date", new Date());
		p2.put("lesson_type_id", lessonTypeId);
		p2.put("lesson_mode_id",lessonModeId );
		p2.put("lesson_min", lessonMin);
		p2.put("target_person", targetPerson);
		p2.put("description",description );
		p2.put("name",lessonName );
		p2.put("teaching_mode",teachingMode );
		p2.put("equipment",equipment );
		onlineClassroomMapper.saveOnlineLessonDetails(p2);
		
		return new HashMap<>();
	}



	@Override
	public PageInfo getOnlineLessonOrderData(Integer pageNum, Integer pageSize,String userInfo) {
		PageHelper.startPage(pageNum, pageSize);
		if(userInfo!=null&&userInfo.trim().length()>0){
			userInfo="%"+userInfo.trim()+"%";
		}
		List<Map<String, Object>> list=onlineClassroomMapper.getOnlineLessonOrderData(userInfo);
		
		return new PageInfo<>(list);
	}



	@Override
	public Map<String, Object> deleteLessonList(String roomNum) {
		onlineClassroomMapper.deleteLessonList(roomNum);
		return new HashMap<>();
	}


	@Transactional
	@Override
	public Map<String, Object> deleteLecturerTimePlan(int id) {
		onlineClassroomMapper.deleteLecturerTimePlanById(id);
		return new HashMap<>();
	}



	@Override
	public Map<String, Object> onlineLessonGeneralUpdatePushStatus(int detailsId, String pushStatus) {
		onlineClassroomMapper.onlineLessonGeneralUpdatePushStatus(detailsId,pushStatus);
		return new HashMap<>();
	}



	@Override
	public Map<String, Object> getCoursePacket() {
		Map<String, Object> result=new HashMap<>();
		List<Map<String, Object>> list= onlineClassroomMapper.getCoursePacket();
		result.put("list", list);
		return result;
	}



	@Override
	public Map<String, Object> createOrder(String studentAccount, int buyMoney, int coursePacketId) {
		Map<String, Object> result=new HashMap<>();
		
		//查询学生
		Map<String, Object> studentMap=onlineClassroomMapper.getStudentByAccount(studentAccount);
		int studentId=0;
		if(studentMap==null||studentMap.isEmpty()){
			result.put("errMsg", "该学生不存在");
			return result;
		}
		
		studentId=Integer.parseInt(studentMap.get("id")+"");
		
		//查询课程包
		Map<String, Object> coursePacketMap=onlineClassroomMapper.getCoursePacketById(coursePacketId);
		
		String date=DateUtil.convertToString(new Date(), DateUtil.STR_DATE_TIME_NO_SEPARATOR);
		int radomNum = (int)(Math.random()*(9999-1000+1))+1000;
		String orderNo=date+"001"+radomNum;
		
		Map<String, Object> param=new HashMap<>();
		param.put("online_lesson_general_id",coursePacketMap.get("online_lesson_general_id") );
		param.put("online_lesson_details_id", coursePacketId);
		param.put("user_id", studentId);
		param.put("user_type", "s");
		param.put("online_lesson_general_name", coursePacketMap.get("name"));
		param.put("money",coursePacketMap.get("money") );
		param.put("lesson_num", coursePacketMap.get("lesson_num"));
		param.put("once_mondey", coursePacketMap.get("once_mondey"));
		param.put("once_min", coursePacketMap.get("lesson_min"));
		param.put("surplus_lesson_num", coursePacketMap.get("lesson_num"));
		param.put("modify_date",new Date());
		param.put("real_price", buyMoney);
		param.put("order_no", orderNo);
		
		onlineClassroomMapper.createOrder(param);
		return result;
	}

}
