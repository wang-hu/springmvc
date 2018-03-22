package com.shuyang.yc.web;/**
 * @author:wh
 * @date:create in 18-3-1 上午11:22
 */

import com.shuyang.yc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shuyang.yc.domain.Menu;

import java.util.List;

/**
 * @author:wh
 * @create in 18-3-1 上午11:22
 */
@Controller
@RequestMapping("/com/shuyang/yc/menu")
public class MenuController {


    @Autowired
    MenuService menuService;

    @RequestMapping("/init")
    public @ResponseBody List<Menu> listMenus(Integer Id) {

        return menuService.listMenuByParentId(Id);
    }
}
