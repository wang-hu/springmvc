package yc.service.impl;/**
 * @author:wh
 * @date:create in 18-3-1 上午11:23
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.domain.Menu;
import yc.domain.mapper.MenuMapper;
import yc.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author:wh
 * @create in 18-3-1 上午11:23    
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> listMenuByParentId(Integer id) {
        List<Menu> menuLst = menuMapper.listMenuByParentId(0);

        List<Menu> menuList = new ArrayList<>();

        Menu menu = new Menu();

        for(Menu menu1 : menuLst) {
            Integer id1 = menu1.getId();
            Integer parentId = menu1.getParentId();

            if(parentId == 0) {
                menu.setId(id1);
                menu.setText(menu1.getText());
                List<Menu> menuChildren = menuMapper.listMenuByParentId(id1);
                menu.setChildren(menuChildren);
            }
            menuList.add(menu);
        }

        return menuList;
    }
}
