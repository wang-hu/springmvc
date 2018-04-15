package com.shuyang.sys.web;

import com.shuyang.sys.component.Msg;
import com.shuyang.sys.domain.Menu;
import com.shuyang.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/com/shuyang/sys/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/menu_init")
    public String menu_init() {
        return "sys/system_columns";
    }

    @RequestMapping("/addMenu")
    public @ResponseBody Msg addMenu(Menu menu) {
        Msg msg = menuService.insertMenu(menu);
        return msg;
    }

    @RequestMapping("listAllMenus")
    @ResponseBody
    public Msg listAllMenus() {
        Msg msg = menuService.listAllMenus();
        return msg;
    }

    @RequestMapping("listLeftMenus")
    @ResponseBody
    public Msg listLeftMenus(Integer id) {
        Msg msg = menuService.listMenuByParentId(id);
        return msg;
    }
}
