package com.shuyang.sys.service;

import com.shuyang.sys.domain.SysUserInfo;

public interface SysUserInfoService {

    SysUserInfo getSysUserInfoByUserNameAndPassword(String loginName, String password);
}
