package com.shuyang.yc.service.impl;/**
 * @author:wh
 * @date:create in 18-3-1 上午11:23
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shuyang.yc.domain.Menu;
import com.shuyang.yc.domain.mapper.MenuMapper;
import com.shuyang.yc.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wh
 * @create in 18-3-1 上午11:23
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> listMenuByParentId(Integer id) {
        List<Menu> menuLst = menuMapper.listMenuByParentId(0);
        List<Menu> menuList = new ArrayList<>();
        menuList = getMenus(menuLst, menuList);
        return menuList;
    }

    private List<Menu> getMenus(List<Menu> menuLst, List<Menu> menuList) {
        for (Menu menu1 : menuLst) {
            List<Menu> menuChildren = menuMapper.listMenuByParentId(menu1.getId());
            menu1.setChildren(menuChildren);
            if (menu1.getParentId() == 0) {
                menuList.add(menu1);
            }
            if(menuChildren.size() > 0)
                getMenus(menuChildren, menuList);
        }
        return menuList;
    }

}
