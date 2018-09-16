package com.shuyang.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author td-wh
 * @date 2018-03-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserInfo {
    private Integer id;
    private String loginName;
    private String nickName;
    private String userName;
    private String userCode;
    private String userPassword;
    private String unablePassword;
}