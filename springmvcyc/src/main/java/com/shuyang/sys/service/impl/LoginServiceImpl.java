package com.shuyang.sys.service.impl;

import com.shuyang.sys.domain.SysUserInfo;
import com.shuyang.sys.domain.mapper.SysUserInfoMapper;
import com.shuyang.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:wh
 * @create in 18-3-22 下午1:42
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    SysUserInfoMapper sysUserInfoMapper;

    @Override
    public SysUserInfo getSysUserInfoByUserNameAndPassword(String loginName, String password) {
        return sysUserInfoMapper.getSysUserInfoByUserNameAndPassword(loginName,password);
    }
}
