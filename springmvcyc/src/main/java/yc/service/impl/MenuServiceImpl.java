package yc.service.impl;/**
 * @author:wh
 * @date:create in 18-3-1 上午11:23
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import yc.domain.Menu;
import yc.domain.mapper.MenuMapper;
import yc.service.MenuService;

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
        menuList = getMenus(menuList,menuLst);
        return menuList;
    }

    private List<Menu> getMenus(List<Menu> menuList,List<Menu> menuLst) {
        List<Menu> menuChildren = null;

        if(menuLst.size() > 0) {
            for (Menu menu1 : menuLst) {
                Menu menu = new Menu();
                Integer id1 = menu1.getId();
                menu.setId(id1);
                menu.setText(menu1.getText());
                menuChildren = menuMapper.listMenuByParentId(id1);
                menu.setChildren(menuChildren);
                menuList.add(menu);
                if(menuChildren.size() > 0) {
                    return getMenus(menuList,menuChildren);
                }

            }
        }
        return menuList;
    }
}
