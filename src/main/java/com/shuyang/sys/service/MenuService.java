package com.shuyang.sys.service;


import com.shuyang.sys.component.Msg;
import com.shuyang.sys.component.pojo.UrlAuth;
import com.shuyang.sys.domain.Menu;
import com.shuyang.sys.domain.component.TreeNode;

import java.util.List;

public interface MenuService {
    Msg listMenuByParentId(Integer id);

    Msg insertMenu(Menu apply);

    Msg listAllMenus();

    List<UrlAuth> listAuthUrls();
}
