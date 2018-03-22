package com.shuyang.yc.service;


import com.shuyang.yc.domain.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> listMenuByParentId(Integer id);
}
