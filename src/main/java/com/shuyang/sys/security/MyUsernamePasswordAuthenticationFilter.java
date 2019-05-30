package com.shuyang.sys.security;

import com.shuyang.sys.domain.SysUserInfo;
import com.shuyang.sys.domain.mapper.SysUserInfoMapper;
import com.shuyang.sys.service.SysUserInfoService;
import com.shuyang.sys.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    Logger logger = Logger.getLogger("com.shuyang.sys.security.MyUsernamePasswordAuthenticationFilter");

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            logger.warning("Authentication method not supported: " + request.getMethod());
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        SysUserInfo sysUserInfo = sysUserInfoMapper.getSysUserInfoByUserName(username);

        if (sysUserInfo == null || !password.equals(sysUserInfo.getUserPassword())) {
            logger.warning("用户名或者密码错误！");
            throw new UsernameNotFoundException("用户名或者密码错误！");
        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        Object obj = request.getParameter(USERNAME);
        return null == obj ? "" : obj.toString();
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        Object obj = request.getParameter(PASSWORD);
        return null == obj ? "" : obj.toString();
    }
}
