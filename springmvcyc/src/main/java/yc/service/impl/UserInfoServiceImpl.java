package yc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.domain.mapper.UserInfoMapper;
import yc.service.UserInfoService;


/**
 * @author:wh
 * @create in 18-2-24 下午2:49
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;


}
