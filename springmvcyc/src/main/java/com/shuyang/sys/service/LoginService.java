package com.shuyang.sys.service;

import com.shuyang.sys.domain.SysUserInfo;

/**
 * @author:wh
 * @create in 18-3-22 下午1:40
 */

public interface LoginService {
    SysUserInfo getSysUserInfoByUserNameAndPassword(String loginName,String password);

}
