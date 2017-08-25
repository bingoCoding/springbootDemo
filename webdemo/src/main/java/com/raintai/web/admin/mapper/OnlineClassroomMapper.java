package com.raintai.web.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OnlineClassroomMapper {

	
	@Select("select ut.user_from_id,ut.user_to_id,to_char(ut.start_date,'yyyy-mm-dd hh24:mi:ss')  as lesson_start_date,"
		+" to_char(ut.end_date,'yyyy-mm-dd hh24:mi:ss')  as lesson_end_date"
		+" ,s1.real_name,ut.play_books,ut.play_songs "
		+" ,ut.student_camera_video_url, ut.student_pad_video_url, ut.teacher_camera_video_url, ut.teacher_pad_video_url"
		+" ,s2.real_name as student_real_name ,ut.video_url "
		+ " from user_teaching ut "
		+" inner join student s1 on s1.id=ut.user_from_id and ut.user_from_type='s'"
		+" inner join student s2 on s2.id=ut.user_to_id and ut.user_to_type='s'"
		+" where ut.room_num=#{roomNum}")
	public Map<String, Object> getUserTeacherInfo(String roomNum);

	@Select("select min(to_char(u.op_time,'yyyy-mm-dd hh24:mi:ss')) start_op_time,"
		+" max(to_char(u.op_time,'yyyy-mm-dd hh24:mi:ss')) as end_op_time,count(1) as count"
		+" from user_online_room_message u where u.room_id=#{roomNum} and u.role_name=#{role}")
	public Map<String, Object> getRoomMsgInfo(@Param("roomNum") String roomNum, @Param("role") String role);

//	@Select("select app_version,sys_type from user_app_info where user_id=#{uid} and user_type='s' "
//		+" and to_char(op_time,'yyyy-mm-dd hh24:mi:ss')<=#{date} and app_type='online'"
//		+" order by op_time desc limit 1")
//	public Map<String, Object> getUserAppInfo(@Param("uid")int uid,@Param("date")String date);
//	@Select("select u.app_version,u.os_type,u.device_type from user_online_room_message u where u.room_id=#{room_id}  and u.os_version is not null order by   u.op_time asc limit 1")
	@Select("select max(u.app_version) as app_version,max(u.os_type) as os_type,max(u.device_type) as device_type,max(u.os_version) as os_version "
			+" from user_online_room_message u where u.room_id=#{room_id} and u.user_name=#{uid} and u.role_name=#{role}")
	public Map<String, Object> getUserAppInfo(@Param("uid") String uid, @Param("room_id") String room_id, @Param("role") String role);
	
	@Select("select to_char(start_date, 'HH24:MI') AS \"startTime\",to_char(start_date, 'yyyy-MM-dd HH24:MI:SS') AS start_date, room_num AS \"roomNum\" , case WHEN start_date > CURRENT_TIMESTAMP THEN '0' WHEN CURRENT_TIMESTAMP BETWEEN start_date and end_date THEN 'on' ELSE 'end' END AS status from user_teaching where show_status = '1' and to_char(start_date, 'yyyy-MM-dd') = #{dateStr} and user_from_id = ANY (select DISTINCT user_id FROM online_teaching_user where teacher_type = '1') order by \"startTime\"")
	List<Map<String, Object>> getMonitorClassRoomData(@Param("dateStr") String dateStr);

	@Select("select ut.room_num AS \"roomNum\", to_char(end_date - start_date, 'MI') AS duration,tch.real_name AS teacher, tch.account AS \"tchAccount\", stu.real_name AS student, stu.account AS \"stuAccount\" from user_teaching ut left join student stu on ut.user_to_id = stu.id left join student tch on ut.user_from_id = tch.id where ut.room_num = #{roomNum}")
	Map<String, Object> getClassRoomInfo(@Param("roomNum") String roomNum);

	@Select("select action_name, role_name,room_id, to_char(op_time, 'yyyy-MM-dd HH24:MI:SS') AS op_time from user_online_room_message where action_name IN ('in', 'out') AND room_id = #{roomNum}  order by op_time")
	List<Map<String, Object>> getClassRoomAction(@Param("roomNum") String roomNum);
	
	@Select("select round(sum(to_number(u.tx_quality,'9999'))/count(1),1) as avg_tx_quality "
		+" , round(sum(to_number(u.rx_quality,'9999'))/count(1),1) as avg_rx_quality"
		+" from user_net_info u where u.user_id=#{uid} and u.user_type='s'")
	public Map<String, Object> getUserAvgNet(int uid);
	
	@Select("select u.tx_quality ,u.rx_quality from user_net_info u"
			+" where u.user_id=#{uid} and u.user_type='s' order by u.op_time desc limit 1")
	public Map<String, Object> getNowNet(int uid);
	
	@Select("select  to_char(u.op_time,'yyyy-mm-dd hh24:mi:ss') as op_time,s.real_name,u.role_name ,u.action_name"
		+" ,u.camera_mac,u.app_version,u.os_type"
		+ " ,u.os_version, u.device_type"
		+ " from user_online_room_message u "
		+" left join student s on s.id||''=u.user_name"
		+" where u.room_id=#{roomNum} and u.action_name in ('out' , 'in')"
		+" order by u.op_time desc")
	public List<Map<String, Object>> getUserActionList(String roomNum);

	@Select("select s.id,s.account from student s where s.account=#{phone} order by id desc limit 1")
	public Map<String, Object> getUserByPhone(String phone);

	@Select("select max(l.id) from lecturer_time_plan l where l.user_id=#{userId}  and l.user_type='s' and l.day=#{day} and l.show_status='1'")
	public Integer getLecturerTimePlanId(@Param("userId") int userId, @Param("day") String day);

	@Update("update lecturer_time_plan set start_time=#{startHour}  ,end_time=#{endHour}  where id=#{id}")
	public void updateLecturerTimePlan(Map<String, Object> m);

	@Insert("insert into lecturer_time_plan (user_id, user_type, start_time, end_time, show_status, day, modify_date)"
			+" values (#{userId}, 's', #{startHour}, #{endHour}, '1', #{day}, now())")
	public void insertLecturerTimePlan(Map<String, Object> m);

	public List<Map<String, Object>> getLecturerTimePlanData(@Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("userInfo") String userInfo);

	@Insert("insert into online_classroom_feedback (room_num, content, modify_date) values (#{roomNum}, #{content}, now())")
	public void addOnlineClassroomRoomInfoFeedback(@Param("roomNum") String roomNum, @Param("content") String content);

	@Select("select o.content,to_char(o.modify_date,'yyyy-mm-dd hh24:mi:ss') as content_date "
			+" from online_classroom_feedback o where o.room_num=#{roomNum} order by o.modify_date desc")
	public List<Map<String, Object>> getFeedback(String roomNum);

	
	public List<Map<String, Object>> getLessonListData(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("userInfo") String userInfo);
	
	@Select("select ut.song_info from user_teaching_chose_song_ids ut where ut.room_num=#{roomNum} order by ut.modify_date asc")
	public List<Map<String, Object>> getYuyueSongList(String roomNum);

	public List<Map<String, Object>> getOnlineLessonGeneralData();


	@Insert("insert into online_lesson_general(name, lesson_min, remark, show_status, order_num, modify_date, "
			+" lesson_time_group, target_person, description, type_name, app_show, lesson_type_id, lesson_mode_id)"
			+" values (#{name}, #{lesson_min}, #{remark}, #{show_status}, #{order_num}, #{modify_date}, "
			+" #{lesson_time_group}, #{target_person}, #{description}, #{type_name}, #{app_show}, #{lesson_type_id}, #{lesson_mode_id})")
    @Options(useGeneratedKeys=true, keyProperty="id")
	public void saveOnlineLesson(Map<String, Object> p1);

	
	@Insert("insert into online_lesson_details (online_lesson_general_id, lesson_num, money, once_mondey"
			+ ", show_status, order_num, modify_date, real_price, lesson_no,lesson_type_id ,lesson_mode_id ,lesson_min,name ,target_person, description,teaching_mode,equipment)"
			+" values (#{online_lesson_general_id}, #{lesson_num}, #{money}, #{once_mondey}"
			+ ", #{show_status}, #{order_num}, #{modify_date}, #{real_price}, #{lesson_no}, #{lesson_type_id} , #{lesson_mode_id} , #{lesson_min},#{name} ,#{target_person} ,#{description},#{teaching_mode},#{equipment})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void saveOnlineLessonDetails(Map<String, Object> p2);

	@Delete("delete from lecturer_time_plan where user_id=#{userId} and user_type='s' and  day=#{day}")
	public void deleteLecturerTimePlan(@Param("userId") int userId, @Param("day") String day);

//	@Select("select ol.online_lesson_general_name,ol.once_min,s.real_name,s.account"
//		+" ,ol.money,ol.surplus_lesson_num,ol.lesson_num,ol.real_price "
//		+" ,to_char(ol.modify_date,'yyyy-mm-dd hh24:mi:ss') as buy_date"
//		+" from online_lesson_buy_general ol"
//		+" inner join student s on ol.user_id=s.id"
//		+" where 1=1 order by ol.modify_date desc ")
	public List<Map<String, Object>> getOnlineLessonOrderData(@Param("userInfo") String userInfo);

	@Update("update user_teaching set show_status='2' where room_num=#{roomNum}")
	public void deleteLessonList(String roomNum);

	@Delete("delete from lecturer_time_plan where id=#{id}")
	public void deleteLecturerTimePlanById(@Param("id") int id);

	@Update("update online_lesson_details set show_status=#{pushStatus} where id=#{id}")
	public void onlineLessonGeneralUpdatePushStatus(@Param("id") int detailsId, @Param("pushStatus") String pushStatus);

	@Select("	select o1.id as online_lesson_details_id,o1.lesson_no,o1.name as lesson_name"
			+" ,olt.name type_name,olm.name mode_name,o1.lesson_min,o1.money,o1.lesson_num,o1.once_mondey"
			+" ,o1.show_status from online_lesson_general  o"
			+" left join online_lesson_details o1 on o.id=o1.online_lesson_general_id"
			+" left join online_lesson_type olt on olt.id=o1.lesson_type_id"
			+" left join online_lesson_mode olm on olm.id=o1.lesson_mode_id"
			+" where  o1.show_status='1'"
			+" order by o1.id desc")
	public List<Map<String, Object>> getCoursePacket();

	@Select("select s.id ,s.account from student s where s.account=#{studentAccount} limit 1")
	public Map<String, Object> getStudentByAccount(String studentAccount);

	@Select("select ol.online_lesson_general_id,ol.id,ol.name,ol.lesson_num,ol.lesson_min,ol.money,ol.once_mondey from online_lesson_details ol where ol.id=#{coursePacketId}")
	public Map<String, Object> getCoursePacketById(int coursePacketId);

	@Insert("insert into  online_lesson_buy_general (online_lesson_general_id, online_lesson_details_id, user_id, user_type, online_lesson_general_name, money, lesson_num, once_mondey, once_min, surplus_lesson_num, modify_date, real_price,order_no)"
			+" values (#{online_lesson_general_id}, #{online_lesson_details_id}, #{user_id}, #{user_type}, #{online_lesson_general_name}, #{money}, #{lesson_num}, #{once_mondey}, #{once_min}, #{surplus_lesson_num}, #{modify_date}, #{real_price},#{order_no})")
	public void createOrder(Map<String, Object> param);
	
}
