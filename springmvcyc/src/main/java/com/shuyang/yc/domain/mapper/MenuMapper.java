package com.shuyang.yc.domain.mapper;

import com.shuyang.yc.domain.Menu;

import java.util.List;

public interface MenuMapper {
    /**根据父节点查找*/
    List<Menu> listMenuByParentId(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}