package com.shuyang.sys.security;

import com.shuyang.sys.component.pojo.UserAuth;
import com.shuyang.sys.domain.SysUserInfo;
import com.shuyang.sys.domain.mapper.SysUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    //登陆验证时，通过username获取用户的所有权限信息，

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        SysUserInfo sysUserInfo = sysUserInfoMapper.getSysUserInfoByUserName(userName);

        Collection<GrantedAuthority> userAuths = new ArrayList<>();

        List<UserAuth> userAuthList = sysUserInfoMapper.listUserAuthorities(userName);

        for (UserAuth auth : userAuthList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(auth.getAuthority());
            userAuths.add(grantedAuthority);
        }

        User user = new User(userName, sysUserInfo.getUserPassword(), true, true, true, true, userAuths);
        return user;
    }
}
