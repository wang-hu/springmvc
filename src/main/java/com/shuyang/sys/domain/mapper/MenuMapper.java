package com.shuyang.sys.domain.mapper;

import com.shuyang.sys.component.pojo.UrlAuth;
import com.shuyang.sys.domain.Menu;

import java.util.List;

public interface MenuMapper {
    /**根据父节点查找*/
    List<Menu> listMenuByParentId(Integer id);

    List<UrlAuth> listAuthUrls();

    int deleteByPrimaryKey(Integer id);

    int insertMenu(Menu record);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> listAllMenus();
}