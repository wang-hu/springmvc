package com.shuyang.sys.security;

import com.shuyang.sys.domain.SysUserInfo;
import com.shuyang.sys.domain.mapper.SysUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    //登陆验证时，通过username获取用户的所有权限信息，

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        SysUserInfo users = sysUserInfoMapper.getSysUserInfoByUserName(userName);
        if(users == null) {
            throw new UsernameNotFoundException(userName);
        }

        Collection<GrantedAuthority> auths = new ArrayList<>();

        GrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
        GrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");

        if (userName.equals("wanghu")) {
            auths = new ArrayList<>();
            auths.add(auth1);
            auths.add(auth2);
        }

        User user = new User(userName, "123", true, true, true, true, auths);
        return user;
    }
}
