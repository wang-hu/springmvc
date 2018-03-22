package com.shuyang.yc.web;

import com.shuyang.yc.domain.UserInfo;
import com.shuyang.yc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wh
 * @create in 18-2-24 下午2:47
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @RequestMapping("/user_page")
    public String user_init() {
        return "yc/user/user";
    }


    @RequestMapping("/showUser")
    public @ResponseBody List<UserInfo> listUserInfo() {
        //List<UserInfo> list = userService.listUserInfo();
        return new ArrayList(null);
    }
}
