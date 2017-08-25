package com.raintai.web.admin.mapper;

import java.util.List;
import java.util.Map;

import com.raintai.web.admin.sqlProvider.StudentDynaSqlProvider;
import org.apache.ibatis.annotations.*;

public interface StudentMapper {

	List<Map<String, Object>> getGeneralInfoData(@Param("userInfo") String userInfo);

	List<Map<String, Object>> getliveErrPushUserData(@Param("userInfo") String userInfo);

	@Select("select s.id,s.account,s.real_name from student s where s.account=#{studentAccount} limit 1")
	Map<String, Object> getStudentInfoByAccount(String studentAccount);

	@Select("select count(1) from live_err_push_user l where l.user_id=#{studentId} and l.push_account=#{pushUserPhone}")
	int getPushCout(@Param("studentId") int studentId, @Param("pushUserPhone") String pushUserPhone);

	@Insert("insert into live_err_push_user(user_account, user_id, push_account, show_status, modify_date, push_user_name)"
			+" values (#{studentAccount}, #{studentId}, #{pushUserPhone}, '1', now(), #{pushUserName})")
	void insertPushUser(@Param("studentAccount") String studentAccount, @Param("studentId") int studentId, @Param("pushUserPhone") String pushUserPhone, @Param("pushUserName") String pushUserName);

	
	@Select("select  c.week,c.date_day as day,s.start_time,s.end_time"
			+" from calendar c "
			+" left join shike_time s on 1=1 "
			+" where c.date_day>=#{startDay} and c.date_day<=#{endDay}"
			+" order by c.date_day,s.start_time,s.end_time")
	public List<Map<String, Object>> getDayList(@Param("startDay") String startDay, @Param("endDay") String endDay);

	@Select("select s1.real_name as teacher_name ,to_char(ut.start_date,'yyyy-mm-dd') as day,s2.real_name as student_name,to_char(ut.start_date,'yyyy-mm-dd hh24:mi:ss') as start_date"
		+" ,to_char(ut.end_date,'yyyy-mm-dd hh24:mi:ss')  as end_date from user_teaching ut"
		+" inner join student s1 on ut.user_from_id=s1.id inner join student s2 on ut.user_to_id=s2.id"
		+" where ut.user_from_id in ( select o.user_id from online_teaching_user o where o.teacher_type in ('peilian_app','1')"
		+" ) and  ut.show_status='1'  and to_char(ut.start_date,'yyyy-mm-dd')>=#{startDay} and to_char(ut.start_date,'yyyy-mm-dd')<=#{endDay}"
		+" order by ut.start_date asc")
	public List<Map<String, Object>> getOnlineLesson(@Param("startDay") String startDay, @Param("endDay") String endDay);

	@Select("with a as ( select o.start_time from online_lesson_time o "
		+" where o.group_id=2  order by o.start_time) select a.start_time, "
		+" (select  (case when  min(a1.start_time) is null then '24:00' else min(a1.start_time) end )  as end_time"
		+" from a a1 where a1.start_time>a.start_time) ,c.date_day,c.week"
		+" from a  inner join calendar c on  1=1 "
		+" where c.date_day>=#{startDay} and c.date_day<=#{endDay}"
		+" order by a.start_time,c.date_day")
	List<Map<String, Object>> getLessonDayTime(@Param("startDay") String startDay, @Param("endDay") String endDay);

	@Select("select "
		+" to_char(ut.start_date,'yyyy-mm-dd hh24:mi:ss') as start_date"
		+" ,to_char(ut.end_date,'yyyy-mm-dd hh24:mi:ss') as end_date"
		+" ,s1.real_name as user_from_real_name"
		+" ,s2.real_name as user_to_real_name"
		+" from user_teaching ut "
		+" inner join student s1 on s1.id=ut.user_from_id"
		+" inner join student s2 on s2.id=ut.user_to_id"
		+" where to_char(ut.start_date,'yyyy-mm-dd')>=#{startDay} "
		+" and to_char(ut.start_date,'yyyy-mm-dd')<=#{endDay} "
		+" and ut.show_status='1' and ut.user_from_id in ( "
		+" 	select o.user_id from online_teaching_user o where o.teacher_type in ('1','peilian_app') "
		+" )")
	List<Map<String, Object>> getUserTeachingDayTime(@Param("startDay") String startDay, @Param("endDay") String endDay);
	

	@SelectProvider(type=StudentDynaSqlProvider.class,method="getWorkdeskDataSql")
	List<Map<String, Object>> getWorkdeskData(@Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("userInfo") String userInfo);

	@Insert("insert into user_manager(user_phone, manager_name, show_status, modify_date)"
			+" values (#{managerphone}, #{managername},'1', now())")
	void saveUserManager(@Param("managername") String managername, @Param("managerphone") String managerphone);

	@Update("update user_manager set show_status= '2' where user_phone = #{managerphone}")
	void updateManager(@Param("managerphone") String managerphone);

	@Insert("insert into user_manager_msg(user_phone, show_status,msg, modify_date)"
			+" values (#{userphone},'1',#{msg}, now())")
	void saveRemark(@Param("userphone") String userphone, @Param("msg") String msg);
}
