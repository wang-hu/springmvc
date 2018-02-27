package yc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.domain.User;
import yc.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wh
 * @create in 18-2-24 下午2:47
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/user_page")
    public String user_init() {
        return "/yc/user";
    }


    @RequestMapping("/showUser")
    public @ResponseBody List<User> listUserInfo() {
        List<User> list = userService.listUserInfo();
        return new ArrayList(list);
    }
}
