package yc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:wh
 * @create in 18-2-27 下午1:51
 */
@Controller
@RequestMapping("/yc")
public class LoginController {

    @RequestMapping("/login")
    public String login_init() {
        return "/index";
    }
}
