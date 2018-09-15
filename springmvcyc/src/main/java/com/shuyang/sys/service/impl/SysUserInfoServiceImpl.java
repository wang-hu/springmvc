package com.shuyang.sys.service.impl;

import com.shuyang.sys.domain.SysUserInfo;
import com.shuyang.sys.domain.mapper.SysUserInfoMapper;
import com.shuyang.sys.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService{

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public SysUserInfo getSysUserInfoByUserNameAndPassword(String loginName, String password) {

        return sysUserInfoMapper.getSysUserInfoByUserNameAndPassword(loginName, password);
    }
}
