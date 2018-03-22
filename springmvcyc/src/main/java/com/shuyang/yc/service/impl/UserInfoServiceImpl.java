package com.shuyang.yc.service.impl;

import com.shuyang.yc.domain.mapper.UserInfoMapper;
import com.shuyang.yc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author:wh
 * @create in 18-2-24 下午2:49
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;


}
