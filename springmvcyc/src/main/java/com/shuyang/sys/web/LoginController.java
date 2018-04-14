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

        return "home";
    }


    @RequestMapping("/index")
    public String home_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);
        return "yc/index";
    }

    @RequestMapping("/admin_competence")
    public String admin_competence_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);
        return "yc/home/admin_competence";
    }
    @RequestMapping("/rizhi_list")
    public String rizhi_list_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);
        return "yc/home/rizhi_list";
    }@RequestMapping("/personal_info")
    public String personal_info_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);
        return "yc/home/personal_info";
    }@RequestMapping("/administrator_list")
    public String administrator_list_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);
        return "yc/home/administrator_list";
    }@RequestMapping("/system_info")
    public String home1_init(String loginName,String password) {

        // loginService.getSysUserInfoByUserNameAndPassword(loginName,password);
        return "yc/home/system_info";
    }
}
