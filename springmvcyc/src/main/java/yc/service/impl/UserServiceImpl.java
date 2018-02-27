package yc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.domain.User;
import yc.domain.mapper.UserMapper;
import yc.service.UserService;

import java.util.List;

/**
 * @author:wh
 * @create in 18-2-24 下午2:49
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> listUserInfo() {
        return userMapper.listUserInfo();
    }
}
