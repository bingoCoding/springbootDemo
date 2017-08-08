package com.example.model;

import java.util.Date;
import javax.persistence.*;

public class Student {
    /**
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 学员编号
     */
    @Column(name = "student_no")
    private String studentNo;

    /**
     * 学生积分
     */
    @Column(name = "student_points")
    private Double studentPoints;

    /**
     * 姓名
     */
    private String name;

    /**
     * 姓名拼音
     */
    @Column(name = "name_py")
    private String namePy;

    /**
     * 性别
     */
    private String sex;

    /**
     * 证件类型no
     */
    @Column(name = "card_type_no")
    private Integer cardTypeNo;

    /**
     * 证件类型
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 证件号码
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 地区/籍贯
     */
    private String area;

    /**
     * 民族
     */
    private String nation;

    /**
     * 照片名
     */
    @Column(name = "photo_name")
    private String photoName;

    /**
     * 照片扩展名
     */
    @Column(name = "photo_ext")
    private String photoExt;

    /**
     * 照片带路径全名
     */
    @Column(name = "photo_all_name")
    private String photoAllName;

    /**
     * 照片无扩展名名称
     */
    @Column(name = "photo_top_name")
    private String photoTopName;

    /**
     * 照片原名称
     */
    @Column(name = "photo_old_name")
    private String photoOldName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮编
     */
    @Column(name = "post_no")
    private String postNo;

    /**
     * E-MAIL
     */
    private String email;

    /**
     * 联系地址
     */
    private String addr;

    /**
     * 联系人姓名1
     */
    private String name1;

    /**
     * 联系人联系电话1
     */
    private String phone1;

    /**
     * 联系人关系1
     */
    private String relation1;

    /**
     * 联系人关系号1
     */
    @Column(name = "relation_no1")
    private Integer relationNo1;

    /**
     * 联系人职业1
     */
    private String metier1;

    /**
     * 联系人姓名2
     */
    private String name2;

    /**
     * 联系人联系电话2
     */
    private String phone2;

    /**
     * 联系人关系2
     */
    private String relation2;

    /**
     * 联系人关系号2
     */
    @Column(name = "relation_no2")
    private Integer relationNo2;

    /**
     * 联系人职业2
     */
    private String metier2;

    /**
     * 账户余额
     */
    @Column(name = "account_balance")
    private Double accountBalance;

    /**
     * 折扣率
     */
    @Column(name = "discount_ppt")
    private Double discountPpt;

    /**
     * 折扣类型
     */
    @Column(name = "discount_type")
    private String discountType;

    /**
     * 折扣类型id
     */
    @Column(name = "discount_type_id")
    private String discountTypeId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 添加时间
     */
    @Column(name = "insert_time")
    private Date insertTime;

    /**
     * 创建人ID
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 创建人
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 逻辑删除
     */
    @Column(name = "del_boolean")
    private String delBoolean;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 版本
     */
    private Long version;

    /**
     * 复制的版本
     */
    @Column(name = "copy_version")
    private Long copyVersion;

    /**
     * 复制时间
     */
    @Column(name = "copy_time")
    private Date copyTime;

    /**
     * 逻辑状态
     */
    @Column(name = "logic_state")
    private Integer logicState;

    /**
     * 最后上课时间
     */
    @Column(name = "end_class_time")
    private Date endClassTime;

    /**
     * 是否是会员
     */
    @Column(name = "member_boolean")
    private Integer memberBoolean;

    /**
     * 会员号
     */
    @Column(name = "member_no")
    private String memberNo;

    /**
     * 根机构id
     */
    @Column(name = "base_org_id")
    private String baseOrgId;

    /**
     * 根机构no
     */
    @Column(name = "base_org_no")
    private String baseOrgNo;

    /**
     * 根机构名
     */
    @Column(name = "base_org_name")
    private String baseOrgName;

    /**
     * 按时计费练琴卡状态
     */
    @Column(name = "timing_practise_card_state")
    private Integer timingPractiseCardState;

    /**
     * 按时计费练琴卡id
     */
    @Column(name = "timing_practise_card_id")
    private String timingPractiseCardId;

    /**
     * 按时计费练琴卡号
     */
    @Column(name = "timing_practise_card_no")
    private String timingPractiseCardNo;

    /**
     * 按时计费练琴卡密码
     */
    @Column(name = "timing_practise_password")
    private String timingPractisePassword;

    /**
     * 按时计费练琴卡发卡日期
     */
    @Column(name = "timing_practise_card_time")
    private Date timingPractiseCardTime;

    /**
     * 按时计费练琴卡开始时间
     */
    @Column(name = "timing_practise_card_begin_time")
    private Date timingPractiseCardBeginTime;

    /**
     * 按时计费练琴卡分校
     */
    @Column(name = "timing_practise_card_school")
    private String timingPractiseCardSchool;

    /**
     * 按时计费练琴卡分校id
     */
    @Column(name = "timing_practise_card_school_id")
    private String timingPractiseCardSchoolId;

    /**
     * 按时计费练琴卡教室
     */
    @Column(name = "timing_practise_card_classroom")
    private String timingPractiseCardClassroom;

    /**
     * 按时计费练琴卡教室id
     */
    @Column(name = "timing_practise_card_classroom_id")
    private String timingPractiseCardClassroomId;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取学员编号
     *
     * @return student_no - 学员编号
     */
    public String getStudentNo() {
        return studentNo;
    }

    /**
     * 设置学员编号
     *
     * @param studentNo 学员编号
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    /**
     * 获取学生积分
     *
     * @return student_points - 学生积分
     */
    public Double getStudentPoints() {
        return studentPoints;
    }

    /**
     * 设置学生积分
     *
     * @param studentPoints 学生积分
     */
    public void setStudentPoints(Double studentPoints) {
        this.studentPoints = studentPoints;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取姓名拼音
     *
     * @return name_py - 姓名拼音
     */
    public String getNamePy() {
        return namePy;
    }

    /**
     * 设置姓名拼音
     *
     * @param namePy 姓名拼音
     */
    public void setNamePy(String namePy) {
        this.namePy = namePy == null ? null : namePy.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取证件类型no
     *
     * @return card_type_no - 证件类型no
     */
    public Integer getCardTypeNo() {
        return cardTypeNo;
    }

    /**
     * 设置证件类型no
     *
     * @param cardTypeNo 证件类型no
     */
    public void setCardTypeNo(Integer cardTypeNo) {
        this.cardTypeNo = cardTypeNo;
    }

    /**
     * 获取证件类型
     *
     * @return card_type - 证件类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置证件类型
     *
     * @param cardType 证件类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 获取证件号码
     *
     * @return card_no - 证件号码
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置证件号码
     *
     * @param cardNo 证件号码
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取国籍
     *
     * @return nationality - 国籍
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 设置国籍
     *
     * @param nationality 国籍
     */
    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    /**
     * 获取地区/籍贯
     *
     * @return area - 地区/籍贯
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区/籍贯
     *
     * @param area 地区/籍贯
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 获取照片名
     *
     * @return photo_name - 照片名
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * 设置照片名
     *
     * @param photoName 照片名
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    /**
     * 获取照片扩展名
     *
     * @return photo_ext - 照片扩展名
     */
    public String getPhotoExt() {
        return photoExt;
    }

    /**
     * 设置照片扩展名
     *
     * @param photoExt 照片扩展名
     */
    public void setPhotoExt(String photoExt) {
        this.photoExt = photoExt == null ? null : photoExt.trim();
    }

    /**
     * 获取照片带路径全名
     *
     * @return photo_all_name - 照片带路径全名
     */
    public String getPhotoAllName() {
        return photoAllName;
    }

    /**
     * 设置照片带路径全名
     *
     * @param photoAllName 照片带路径全名
     */
    public void setPhotoAllName(String photoAllName) {
        this.photoAllName = photoAllName == null ? null : photoAllName.trim();
    }

    /**
     * 获取照片无扩展名名称
     *
     * @return photo_top_name - 照片无扩展名名称
     */
    public String getPhotoTopName() {
        return photoTopName;
    }

    /**
     * 设置照片无扩展名名称
     *
     * @param photoTopName 照片无扩展名名称
     */
    public void setPhotoTopName(String photoTopName) {
        this.photoTopName = photoTopName == null ? null : photoTopName.trim();
    }

    /**
     * 获取照片原名称
     *
     * @return photo_old_name - 照片原名称
     */
    public String getPhotoOldName() {
        return photoOldName;
    }

    /**
     * 设置照片原名称
     *
     * @param photoOldName 照片原名称
     */
    public void setPhotoOldName(String photoOldName) {
        this.photoOldName = photoOldName == null ? null : photoOldName.trim();
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取邮编
     *
     * @return post_no - 邮编
     */
    public String getPostNo() {
        return postNo;
    }

    /**
     * 设置邮编
     *
     * @param postNo 邮编
     */
    public void setPostNo(String postNo) {
        this.postNo = postNo == null ? null : postNo.trim();
    }

    /**
     * 获取E-MAIL
     *
     * @return email - E-MAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置E-MAIL
     *
     * @param email E-MAIL
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取联系地址
     *
     * @return addr - 联系地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置联系地址
     *
     * @param addr 联系地址
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 获取联系人姓名1
     *
     * @return name1 - 联系人姓名1
     */
    public String getName1() {
        return name1;
    }

    /**
     * 设置联系人姓名1
     *
     * @param name1 联系人姓名1
     */
    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    /**
     * 获取联系人联系电话1
     *
     * @return phone1 - 联系人联系电话1
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * 设置联系人联系电话1
     *
     * @param phone1 联系人联系电话1
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1 == null ? null : phone1.trim();
    }

    /**
     * 获取联系人关系1
     *
     * @return relation1 - 联系人关系1
     */
    public String getRelation1() {
        return relation1;
    }

    /**
     * 设置联系人关系1
     *
     * @param relation1 联系人关系1
     */
    public void setRelation1(String relation1) {
        this.relation1 = relation1 == null ? null : relation1.trim();
    }

    /**
     * 获取联系人关系号1
     *
     * @return relation_no1 - 联系人关系号1
     */
    public Integer getRelationNo1() {
        return relationNo1;
    }

    /**
     * 设置联系人关系号1
     *
     * @param relationNo1 联系人关系号1
     */
    public void setRelationNo1(Integer relationNo1) {
        this.relationNo1 = relationNo1;
    }

    /**
     * 获取联系人职业1
     *
     * @return metier1 - 联系人职业1
     */
    public String getMetier1() {
        return metier1;
    }

    /**
     * 设置联系人职业1
     *
     * @param metier1 联系人职业1
     */
    public void setMetier1(String metier1) {
        this.metier1 = metier1 == null ? null : metier1.trim();
    }

    /**
     * 获取联系人姓名2
     *
     * @return name2 - 联系人姓名2
     */
    public String getName2() {
        return name2;
    }

    /**
     * 设置联系人姓名2
     *
     * @param name2 联系人姓名2
     */
    public void setName2(String name2) {
        this.name2 = name2 == null ? null : name2.trim();
    }

    /**
     * 获取联系人联系电话2
     *
     * @return phone2 - 联系人联系电话2
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * 设置联系人联系电话2
     *
     * @param phone2 联系人联系电话2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2 == null ? null : phone2.trim();
    }

    /**
     * 获取联系人关系2
     *
     * @return relation2 - 联系人关系2
     */
    public String getRelation2() {
        return relation2;
    }

    /**
     * 设置联系人关系2
     *
     * @param relation2 联系人关系2
     */
    public void setRelation2(String relation2) {
        this.relation2 = relation2 == null ? null : relation2.trim();
    }

    /**
     * 获取联系人关系号2
     *
     * @return relation_no2 - 联系人关系号2
     */
    public Integer getRelationNo2() {
        return relationNo2;
    }

    /**
     * 设置联系人关系号2
     *
     * @param relationNo2 联系人关系号2
     */
    public void setRelationNo2(Integer relationNo2) {
        this.relationNo2 = relationNo2;
    }

    /**
     * 获取联系人职业2
     *
     * @return metier2 - 联系人职业2
     */
    public String getMetier2() {
        return metier2;
    }

    /**
     * 设置联系人职业2
     *
     * @param metier2 联系人职业2
     */
    public void setMetier2(String metier2) {
        this.metier2 = metier2 == null ? null : metier2.trim();
    }

    /**
     * 获取账户余额
     *
     * @return account_balance - 账户余额
     */
    public Double getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置账户余额
     *
     * @param accountBalance 账户余额
     */
    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 获取折扣率
     *
     * @return discount_ppt - 折扣率
     */
    public Double getDiscountPpt() {
        return discountPpt;
    }

    /**
     * 设置折扣率
     *
     * @param discountPpt 折扣率
     */
    public void setDiscountPpt(Double discountPpt) {
        this.discountPpt = discountPpt;
    }

    /**
     * 获取折扣类型
     *
     * @return discount_type - 折扣类型
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * 设置折扣类型
     *
     * @param discountType 折扣类型
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    /**
     * 获取折扣类型id
     *
     * @return discount_type_id - 折扣类型id
     */
    public String getDiscountTypeId() {
        return discountTypeId;
    }

    /**
     * 设置折扣类型id
     *
     * @param discountTypeId 折扣类型id
     */
    public void setDiscountTypeId(String discountTypeId) {
        this.discountTypeId = discountTypeId == null ? null : discountTypeId.trim();
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取添加时间
     *
     * @return insert_time - 添加时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置添加时间
     *
     * @param insertTime 添加时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 获取创建人ID
     *
     * @return create_user_id - 创建人ID
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人ID
     *
     * @param createUserId 创建人ID
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * 获取创建人
     *
     * @return create_user_name - 创建人
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置创建人
     *
     * @param createUserName 创建人
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 获取逻辑删除
     *
     * @return del_boolean - 逻辑删除
     */
    public String getDelBoolean() {
        return delBoolean;
    }

    /**
     * 设置逻辑删除
     *
     * @param delBoolean 逻辑删除
     */
    public void setDelBoolean(String delBoolean) {
        this.delBoolean = delBoolean == null ? null : delBoolean.trim();
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取复制的版本
     *
     * @return copy_version - 复制的版本
     */
    public Long getCopyVersion() {
        return copyVersion;
    }

    /**
     * 设置复制的版本
     *
     * @param copyVersion 复制的版本
     */
    public void setCopyVersion(Long copyVersion) {
        this.copyVersion = copyVersion;
    }

    /**
     * 获取复制时间
     *
     * @return copy_time - 复制时间
     */
    public Date getCopyTime() {
        return copyTime;
    }

    /**
     * 设置复制时间
     *
     * @param copyTime 复制时间
     */
    public void setCopyTime(Date copyTime) {
        this.copyTime = copyTime;
    }

    /**
     * 获取逻辑状态
     *
     * @return logic_state - 逻辑状态
     */
    public Integer getLogicState() {
        return logicState;
    }

    /**
     * 设置逻辑状态
     *
     * @param logicState 逻辑状态
     */
    public void setLogicState(Integer logicState) {
        this.logicState = logicState;
    }

    /**
     * 获取最后上课时间
     *
     * @return end_class_time - 最后上课时间
     */
    public Date getEndClassTime() {
        return endClassTime;
    }

    /**
     * 设置最后上课时间
     *
     * @param endClassTime 最后上课时间
     */
    public void setEndClassTime(Date endClassTime) {
        this.endClassTime = endClassTime;
    }

    /**
     * 获取是否是会员
     *
     * @return member_boolean - 是否是会员
     */
    public Integer getMemberBoolean() {
        return memberBoolean;
    }

    /**
     * 设置是否是会员
     *
     * @param memberBoolean 是否是会员
     */
    public void setMemberBoolean(Integer memberBoolean) {
        this.memberBoolean = memberBoolean;
    }

    /**
     * 获取会员号
     *
     * @return member_no - 会员号
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 设置会员号
     *
     * @param memberNo 会员号
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 获取根机构id
     *
     * @return base_org_id - 根机构id
     */
    public String getBaseOrgId() {
        return baseOrgId;
    }

    /**
     * 设置根机构id
     *
     * @param baseOrgId 根机构id
     */
    public void setBaseOrgId(String baseOrgId) {
        this.baseOrgId = baseOrgId == null ? null : baseOrgId.trim();
    }

    /**
     * 获取根机构no
     *
     * @return base_org_no - 根机构no
     */
    public String getBaseOrgNo() {
        return baseOrgNo;
    }

    /**
     * 设置根机构no
     *
     * @param baseOrgNo 根机构no
     */
    public void setBaseOrgNo(String baseOrgNo) {
        this.baseOrgNo = baseOrgNo == null ? null : baseOrgNo.trim();
    }

    /**
     * 获取根机构名
     *
     * @return base_org_name - 根机构名
     */
    public String getBaseOrgName() {
        return baseOrgName;
    }

    /**
     * 设置根机构名
     *
     * @param baseOrgName 根机构名
     */
    public void setBaseOrgName(String baseOrgName) {
        this.baseOrgName = baseOrgName == null ? null : baseOrgName.trim();
    }

    /**
     * 获取按时计费练琴卡状态
     *
     * @return timing_practise_card_state - 按时计费练琴卡状态
     */
    public Integer getTimingPractiseCardState() {
        return timingPractiseCardState;
    }

    /**
     * 设置按时计费练琴卡状态
     *
     * @param timingPractiseCardState 按时计费练琴卡状态
     */
    public void setTimingPractiseCardState(Integer timingPractiseCardState) {
        this.timingPractiseCardState = timingPractiseCardState;
    }

    /**
     * 获取按时计费练琴卡id
     *
     * @return timing_practise_card_id - 按时计费练琴卡id
     */
    public String getTimingPractiseCardId() {
        return timingPractiseCardId;
    }

    /**
     * 设置按时计费练琴卡id
     *
     * @param timingPractiseCardId 按时计费练琴卡id
     */
    public void setTimingPractiseCardId(String timingPractiseCardId) {
        this.timingPractiseCardId = timingPractiseCardId == null ? null : timingPractiseCardId.trim();
    }

    /**
     * 获取按时计费练琴卡号
     *
     * @return timing_practise_card_no - 按时计费练琴卡号
     */
    public String getTimingPractiseCardNo() {
        return timingPractiseCardNo;
    }

    /**
     * 设置按时计费练琴卡号
     *
     * @param timingPractiseCardNo 按时计费练琴卡号
     */
    public void setTimingPractiseCardNo(String timingPractiseCardNo) {
        this.timingPractiseCardNo = timingPractiseCardNo == null ? null : timingPractiseCardNo.trim();
    }

    /**
     * 获取按时计费练琴卡密码
     *
     * @return timing_practise_password - 按时计费练琴卡密码
     */
    public String getTimingPractisePassword() {
        return timingPractisePassword;
    }

    /**
     * 设置按时计费练琴卡密码
     *
     * @param timingPractisePassword 按时计费练琴卡密码
     */
    public void setTimingPractisePassword(String timingPractisePassword) {
        this.timingPractisePassword = timingPractisePassword == null ? null : timingPractisePassword.trim();
    }

    /**
     * 获取按时计费练琴卡发卡日期
     *
     * @return timing_practise_card_time - 按时计费练琴卡发卡日期
     */
    public Date getTimingPractiseCardTime() {
        return timingPractiseCardTime;
    }

    /**
     * 设置按时计费练琴卡发卡日期
     *
     * @param timingPractiseCardTime 按时计费练琴卡发卡日期
     */
    public void setTimingPractiseCardTime(Date timingPractiseCardTime) {
        this.timingPractiseCardTime = timingPractiseCardTime;
    }

    /**
     * 获取按时计费练琴卡开始时间
     *
     * @return timing_practise_card_begin_time - 按时计费练琴卡开始时间
     */
    public Date getTimingPractiseCardBeginTime() {
        return timingPractiseCardBeginTime;
    }

    /**
     * 设置按时计费练琴卡开始时间
     *
     * @param timingPractiseCardBeginTime 按时计费练琴卡开始时间
     */
    public void setTimingPractiseCardBeginTime(Date timingPractiseCardBeginTime) {
        this.timingPractiseCardBeginTime = timingPractiseCardBeginTime;
    }

    /**
     * 获取按时计费练琴卡分校
     *
     * @return timing_practise_card_school - 按时计费练琴卡分校
     */
    public String getTimingPractiseCardSchool() {
        return timingPractiseCardSchool;
    }

    /**
     * 设置按时计费练琴卡分校
     *
     * @param timingPractiseCardSchool 按时计费练琴卡分校
     */
    public void setTimingPractiseCardSchool(String timingPractiseCardSchool) {
        this.timingPractiseCardSchool = timingPractiseCardSchool == null ? null : timingPractiseCardSchool.trim();
    }

    /**
     * 获取按时计费练琴卡分校id
     *
     * @return timing_practise_card_school_id - 按时计费练琴卡分校id
     */
    public String getTimingPractiseCardSchoolId() {
        return timingPractiseCardSchoolId;
    }

    /**
     * 设置按时计费练琴卡分校id
     *
     * @param timingPractiseCardSchoolId 按时计费练琴卡分校id
     */
    public void setTimingPractiseCardSchoolId(String timingPractiseCardSchoolId) {
        this.timingPractiseCardSchoolId = timingPractiseCardSchoolId == null ? null : timingPractiseCardSchoolId.trim();
    }

    /**
     * 获取按时计费练琴卡教室
     *
     * @return timing_practise_card_classroom - 按时计费练琴卡教室
     */
    public String getTimingPractiseCardClassroom() {
        return timingPractiseCardClassroom;
    }

    /**
     * 设置按时计费练琴卡教室
     *
     * @param timingPractiseCardClassroom 按时计费练琴卡教室
     */
    public void setTimingPractiseCardClassroom(String timingPractiseCardClassroom) {
        this.timingPractiseCardClassroom = timingPractiseCardClassroom == null ? null : timingPractiseCardClassroom.trim();
    }

    /**
     * 获取按时计费练琴卡教室id
     *
     * @return timing_practise_card_classroom_id - 按时计费练琴卡教室id
     */
    public String getTimingPractiseCardClassroomId() {
        return timingPractiseCardClassroomId;
    }

    /**
     * 设置按时计费练琴卡教室id
     *
     * @param timingPractiseCardClassroomId 按时计费练琴卡教室id
     */
    public void setTimingPractiseCardClassroomId(String timingPractiseCardClassroomId) {
        this.timingPractiseCardClassroomId = timingPractiseCardClassroomId == null ? null : timingPractiseCardClassroomId.trim();
    }

    /**
     * @return mobile_phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }
}