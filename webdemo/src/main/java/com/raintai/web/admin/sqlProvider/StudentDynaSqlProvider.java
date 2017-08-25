package com.raintai.web.admin.sqlProvider;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public class StudentDynaSqlProvider {

    public String getWorkdeskDataSql(@Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("userInfo") String userInfo){
        StringBuffer sql=new StringBuffer("");
        sql.append("with a as (select o.phone ,max(o.user_name) as baoming_name,max(s.id) as student_id,max(s.real_name) as student_real_name\n" +
                ",max(o.modify_date) as baoming_date\n" +
                "from bespeak_lesson o \n" +
                "left join student s on o.phone=s.account\n" +
                "where o.phone is not null group by o.phone\n" +
                ")\n" +
                ", b as (select ut.user_to_id,count(1) as yueke_num from user_teaching ut where ut.show_status='1' group by ut.user_to_id)\n" +
                "select to_char(a.baoming_date,'yyyy-mm-dd hh24:mi:ss')baoming_date,a.phone ,a.baoming_name,a.student_real_name,b.yueke_num,um.manager_name as  user_manager,\n" +
                "--,ARRAY(select  umm.msg from user_manager_msg umm where umm.user_phone=a.phone )\n" +
                "(\n" +
                "      select array_to_json(array_agg(row_to_json(d)))\n" +
                "      from (\n" +
                "       select  umm.id,umm.msg,to_char(umm.modify_date,'yyyy-mm-dd hh24:mi:ss') modifydata from user_manager_msg umm where umm.user_phone=a.phone\n" +
                "      ) d\n" +
                "    ) as definitions,\n" +
                "(select bl1.fromsource from  bespeak_lesson bl1 where bl1.id in(\n" +
                "\t\t select min(bl.id) from bespeak_lesson bl where bl.phone=a.phone)\n" +
                "\t\t)  as fromsource,\n" +
                "(select bl1.activity_type from  bespeak_lesson bl1 where bl1.id in(\n" +
                " select min(bl.id) from bespeak_lesson bl where bl.phone=a.phone))\n" +
                " as activity_type\n" +
                " \n" +
                " from a \n" +
                " left join b on b.user_to_id=a.student_id\n" +
                " left join user_manager um on um.user_phone=a.phone and um.show_status='1'\n" +
                " ");
        sql.append(" where to_char(a.baoming_date,'yyyy-mm-dd')>=#{beginDate} and to_char(a.baoming_date,'yyyy-mm-dd')<=#{endDate} ");

        if (userInfo!=null&&userInfo.trim().length()>0){
            sql.append(" and (a.phone like #{userInfo} or a.baoming_name like #{userInfo} or um.manager_name like #{userInfo}) ");
        }
        sql.append(" order by a.baoming_date desc,a.student_id desc\n");
        return sql.toString();
    }

}
