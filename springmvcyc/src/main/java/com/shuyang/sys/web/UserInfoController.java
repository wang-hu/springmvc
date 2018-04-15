package com.shuyang.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/com/shuyang/sys/user")
public class UserInfoController {

    @RequestMapping("user_init")
    public String user_init() {
        return "sys/administrator_list";
    }
}
