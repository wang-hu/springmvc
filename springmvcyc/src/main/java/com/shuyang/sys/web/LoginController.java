package com.shuyang.sys.web;

import com.shuyang.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:wh
 * @create in 18-2-27 下午1:51
 */
@Controller
@RequestMapping("/com/shuyang/sys")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);

        return "yc/home";
    }


    @RequestMapping("/index")
    public String home_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);

        return "yc/index";
    }

}
