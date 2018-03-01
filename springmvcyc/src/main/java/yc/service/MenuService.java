package yc.service;


import yc.domain.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> listMenuByParentId(Integer id);
}
