package com.example.dao;

import com.example.model.Student;
import org.apache.ibatis.jdbc.SQL;

public class StudentSqlProvider {

    public String insertSelective(Student record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=CHAR}");
        }
        
        if (record.getStudentNo() != null) {
            sql.VALUES("student_no", "#{studentNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentPoints() != null) {
            sql.VALUES("student_points", "#{studentPoints,jdbcType=DOUBLE}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getNamePy() != null) {
            sql.VALUES("name_py", "#{namePy,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=CHAR}");
        }
        
        if (record.getCardTypeNo() != null) {
            sql.VALUES("card_type_no", "#{cardTypeNo,jdbcType=INTEGER}");
        }
        
        if (record.getCardType() != null) {
            sql.VALUES("card_type", "#{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.VALUES("card_no", "#{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=VARCHAR}");
        }
        
        if (record.getNationality() != null) {
            sql.VALUES("nationality", "#{nationality,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("area", "#{area,jdbcType=VARCHAR}");
        }
        
        if (record.getNation() != null) {
            sql.VALUES("nation", "#{nation,jdbcType=VARCHAR}");
        }
        
        if (record.getPhotoName() != null) {
            sql.VALUES("photo_name", "#{photoName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhotoExt() != null) {
            sql.VALUES("photo_ext", "#{photoExt,jdbcType=VARCHAR}");
        }
        
        if (record.getPhotoAllName() != null) {
            sql.VALUES("photo_all_name", "#{photoAllName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhotoTopName() != null) {
            sql.VALUES("photo_top_name", "#{photoTopName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhotoOldName() != null) {
            sql.VALUES("photo_old_name", "#{photoOldName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPostNo() != null) {
            sql.VALUES("post_no", "#{postNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddr() != null) {
            sql.VALUES("addr", "#{addr,jdbcType=VARCHAR}");
        }
        
        if (record.getName1() != null) {
            sql.VALUES("name1", "#{name1,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone1() != null) {
            sql.VALUES("phone1", "#{phone1,jdbcType=VARCHAR}");
        }
        
        if (record.getRelation1() != null) {
            sql.VALUES("relation1", "#{relation1,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationNo1() != null) {
            sql.VALUES("relation_no1", "#{relationNo1,jdbcType=INTEGER}");
        }
        
        if (record.getMetier1() != null) {
            sql.VALUES("metier1", "#{metier1,jdbcType=VARCHAR}");
        }
        
        if (record.getName2() != null) {
            sql.VALUES("name2", "#{name2,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone2() != null) {
            sql.VALUES("phone2", "#{phone2,jdbcType=VARCHAR}");
        }
        
        if (record.getRelation2() != null) {
            sql.VALUES("relation2", "#{relation2,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationNo2() != null) {
            sql.VALUES("relation_no2", "#{relationNo2,jdbcType=INTEGER}");
        }
        
        if (record.getMetier2() != null) {
            sql.VALUES("metier2", "#{metier2,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountBalance() != null) {
            sql.VALUES("account_balance", "#{accountBalance,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountPpt() != null) {
            sql.VALUES("discount_ppt", "#{discountPpt,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountType() != null) {
            sql.VALUES("discount_type", "#{discountType,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTypeId() != null) {
            sql.VALUES("discount_type_id", "#{discountTypeId,jdbcType=CHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInsertTime() != null) {
            sql.VALUES("insert_time", "#{insertTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.VALUES("create_user_id", "#{createUserId,jdbcType=CHAR}");
        }
        
        if (record.getCreateUserName() != null) {
            sql.VALUES("create_user_name", "#{createUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getDelBoolean() != null) {
            sql.VALUES("del_boolean", "#{delBoolean,jdbcType=CHAR}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("version", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getCopyVersion() != null) {
            sql.VALUES("copy_version", "#{copyVersion,jdbcType=BIGINT}");
        }
        
        if (record.getCopyTime() != null) {
            sql.VALUES("copy_time", "#{copyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLogicState() != null) {
            sql.VALUES("logic_state", "#{logicState,jdbcType=INTEGER}");
        }
        
        if (record.getEndClassTime() != null) {
            sql.VALUES("end_class_time", "#{endClassTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMemberBoolean() != null) {
            sql.VALUES("member_boolean", "#{memberBoolean,jdbcType=INTEGER}");
        }
        
        if (record.getMemberNo() != null) {
            sql.VALUES("member_no", "#{memberNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseOrgId() != null) {
            sql.VALUES("base_org_id", "#{baseOrgId,jdbcType=CHAR}");
        }
        
        if (record.getBaseOrgNo() != null) {
            sql.VALUES("base_org_no", "#{baseOrgNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseOrgName() != null) {
            sql.VALUES("base_org_name", "#{baseOrgName,jdbcType=VARCHAR}");
        }
        
        if (record.getTimingPractiseCardState() != null) {
            sql.VALUES("timing_practise_card_state", "#{timingPractiseCardState,jdbcType=INTEGER}");
        }
        
        if (record.getTimingPractiseCardId() != null) {
            sql.VALUES("timing_practise_card_id", "#{timingPractiseCardId,jdbcType=CHAR}");
        }
        
        if (record.getTimingPractiseCardNo() != null) {
            sql.VALUES("timing_practise_card_no", "#{timingPractiseCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTimingPractisePassword() != null) {
            sql.VALUES("timing_practise_password", "#{timingPractisePassword,jdbcType=VARCHAR}");
        }
        
        if (record.getTimingPractiseCardTime() != null) {
            sql.VALUES("timing_practise_card_time", "#{timingPractiseCardTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimingPractiseCardBeginTime() != null) {
            sql.VALUES("timing_practise_card_begin_time", "#{timingPractiseCardBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimingPractiseCardSchool() != null) {
            sql.VALUES("timing_practise_card_school", "#{timingPractiseCardSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getTimingPractiseCardSchoolId() != null) {
            sql.VALUES("timing_practise_card_school_id", "#{timingPractiseCardSchoolId,jdbcType=CHAR}");
        }
        
        if (record.getTimingPractiseCardClassroom() != null) {
            sql.VALUES("timing_practise_card_classroom", "#{timingPractiseCardClassroom,jdbcType=VARCHAR}");
        }
        
        if (record.getTimingPractiseCardClassroomId() != null) {
            sql.VALUES("timing_practise_card_classroom_id", "#{timingPractiseCardClassroomId,jdbcType=CHAR}");
        }
        
        if (record.getMobilePhone() != null) {
            sql.VALUES("mobile_phone", "#{mobilePhone,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}