package com.example.dao;

import com.example.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface StudentMapper {
    @Insert({
        "insert into student (id, student_no, ",
        "student_points, name, ",
        "name_py, sex, card_type_no, ",
        "card_type, card_no, ",
        "birthday, nationality, ",
        "area, nation, photo_name, ",
        "photo_ext, photo_all_name, ",
        "photo_top_name, photo_old_name, ",
        "phone, post_no, email, ",
        "addr, name1, phone1, ",
        "relation1, relation_no1, ",
        "metier1, name2, ",
        "phone2, relation2, ",
        "relation_no2, metier2, ",
        "account_balance, discount_ppt, ",
        "discount_type, discount_type_id, ",
        "update_time, insert_time, ",
        "create_user_id, create_user_name, ",
        "del_boolean, state, ",
        "version, copy_version, ",
        "copy_time, logic_state, ",
        "end_class_time, member_boolean, ",
        "member_no, base_org_id, ",
        "base_org_no, base_org_name, ",
        "timing_practise_card_state, timing_practise_card_id, ",
        "timing_practise_card_no, timing_practise_password, ",
        "timing_practise_card_time, timing_practise_card_begin_time, ",
        "timing_practise_card_school, timing_practise_card_school_id, ",
        "timing_practise_card_classroom, timing_practise_card_classroom_id, ",
        "mobile_phone)",
        "values (#{id,jdbcType=CHAR}, #{studentNo,jdbcType=VARCHAR}, ",
        "#{studentPoints,jdbcType=DOUBLE}, #{name,jdbcType=VARCHAR}, ",
        "#{namePy,jdbcType=VARCHAR}, #{sex,jdbcType=CHAR}, #{cardTypeNo,jdbcType=INTEGER}, ",
        "#{cardType,jdbcType=VARCHAR}, #{cardNo,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=VARCHAR}, #{nationality,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=VARCHAR}, #{nation,jdbcType=VARCHAR}, #{photoName,jdbcType=VARCHAR}, ",
        "#{photoExt,jdbcType=VARCHAR}, #{photoAllName,jdbcType=VARCHAR}, ",
        "#{photoTopName,jdbcType=VARCHAR}, #{photoOldName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{postNo,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{addr,jdbcType=VARCHAR}, #{name1,jdbcType=VARCHAR}, #{phone1,jdbcType=VARCHAR}, ",
        "#{relation1,jdbcType=VARCHAR}, #{relationNo1,jdbcType=INTEGER}, ",
        "#{metier1,jdbcType=VARCHAR}, #{name2,jdbcType=VARCHAR}, ",
        "#{phone2,jdbcType=VARCHAR}, #{relation2,jdbcType=VARCHAR}, ",
        "#{relationNo2,jdbcType=INTEGER}, #{metier2,jdbcType=VARCHAR}, ",
        "#{accountBalance,jdbcType=DOUBLE}, #{discountPpt,jdbcType=DOUBLE}, ",
        "#{discountType,jdbcType=VARCHAR}, #{discountTypeId,jdbcType=CHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{insertTime,jdbcType=TIMESTAMP}, ",
        "#{createUserId,jdbcType=CHAR}, #{createUserName,jdbcType=VARCHAR}, ",
        "#{delBoolean,jdbcType=CHAR}, #{state,jdbcType=INTEGER}, ",
        "#{version,jdbcType=BIGINT}, #{copyVersion,jdbcType=BIGINT}, ",
        "#{copyTime,jdbcType=TIMESTAMP}, #{logicState,jdbcType=INTEGER}, ",
        "#{endClassTime,jdbcType=TIMESTAMP}, #{memberBoolean,jdbcType=INTEGER}, ",
        "#{memberNo,jdbcType=VARCHAR}, #{baseOrgId,jdbcType=CHAR}, ",
        "#{baseOrgNo,jdbcType=VARCHAR}, #{baseOrgName,jdbcType=VARCHAR}, ",
        "#{timingPractiseCardState,jdbcType=INTEGER}, #{timingPractiseCardId,jdbcType=CHAR}, ",
        "#{timingPractiseCardNo,jdbcType=VARCHAR}, #{timingPractisePassword,jdbcType=VARCHAR}, ",
        "#{timingPractiseCardTime,jdbcType=TIMESTAMP}, #{timingPractiseCardBeginTime,jdbcType=TIMESTAMP}, ",
        "#{timingPractiseCardSchool,jdbcType=VARCHAR}, #{timingPractiseCardSchoolId,jdbcType=CHAR}, ",
        "#{timingPractiseCardClassroom,jdbcType=VARCHAR}, #{timingPractiseCardClassroomId,jdbcType=CHAR}, ",
        "#{mobilePhone,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);
}