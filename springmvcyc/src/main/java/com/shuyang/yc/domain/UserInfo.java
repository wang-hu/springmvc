package com.shuyang.yc.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author wh
 * @Create in 18-2-24 下午2:51
 */
@Data
public class UserInfo {
    private Integer id;                // 序列号
    private String userName;           // 姓名
    private String userIdcard;         // 身份证号
    private String userSex;            // 性别（代码）
    private String userSexChs;         // 性别（中文）
    private Date userBirthday;         // 出生日期
    private String userNation;         // 民族（代码）
    private String userNationChs;      // 民族（中文）
    private Date workDate;             // 参加工作时间
    private Date entrySystemDate;      // 进入本系统时间
    private String marriageStatus;     // 婚姻状况（代码）
    private String marriageStatusChs;  // 婚姻状况（中文）
    private String healthStatus;       // 健康状况（代码）
    private String healthStatusChs;    // 健康状况（中文）
    private String nativePlace;        // 籍贯
    private String birthPlace;         // 出生地
    private String userPolitical;      // 政治面貌（中文）
    private String highestEducation;   // 最高学历或学位等级（中文）
    private String orgName;            // 所在单位
    private String orgCode;            // 单位编码
    private String deptName;           // 所在部门
    private String deptCode;           // 部门编码
    private String userCode;           // 人员编码
    private String postCode;           // 岗位编码
    private String postName;           // 岗位名称
    private String jobLevel;           // 职务级别（中文）
    private String phone;              // 手机号码
}