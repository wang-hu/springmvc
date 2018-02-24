package yc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:wh
 * @create in 18-2-24 下午2:47
 */
@Controller("/user")
public class UserController {

    @RequestMapping("/user_page")
    public String user_init() {
        return "/yc/user";
    }
}
