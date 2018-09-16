package com.shuyang.sys.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shuyang.sys.component.Msg;
import com.shuyang.sys.component.MsgFactory;
import com.shuyang.sys.component.pojo.UrlAuth;
import com.shuyang.sys.domain.component.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shuyang.sys.domain.Menu;
import com.shuyang.sys.domain.mapper.MenuMapper;
import com.shuyang.sys.service.MenuService;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    MsgFactory msgFactory;
    @Override
    public Msg listMenuByParentId(Integer id) {
        List<Menu>  menuLst = menuMapper.listAllMenus();
        return msgFactory.successMsg("success",menuLst);
    }

    @Override
    public Msg insertMenu(Menu apply) {
        if(apply.getPid() == null)
            apply.setPid(0);
        int ret = menuMapper.insertMenu(apply);
        if(ret == 1)
            return msgFactory.successMsg("增加成功");
        else
            return msgFactory.failMsg("增加失败");
    }

    @Override
    public Msg listAllMenus() {
        List<Menu> menuList = menuMapper.listMenuByParentId(0);
        List<TreeNode> treeNodeList = new ArrayList<>();
        JSONArray jsonArray = JSONObject.parseArray(toJsonString(getAllMenus(menuList, treeNodeList)));
        return msgFactory.successMsg("success",jsonArray);
    }

    @Override
    public List<UrlAuth> listAuthUrls() {
        return menuMapper.listAuthUrls();
    }

    private String toJsonString(List<TreeNode> treeNodeList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(TreeNode treeNode : treeNodeList) {
            stringBuilder.append("{");
            stringBuilder.append("\""+treeNode.getId()+"\":\""+treeNode.getName()+"\",");
            if(!CollectionUtils.isEmpty(treeNode.getChildCity())) {
                stringBuilder.append("childCity:[");
                for(TreeNode treeNode1 : treeNode.getChildCity()) {
                    stringBuilder.append("{\""+treeNode1.getId()+"\":\""+treeNode1.getName()+"\"},");
                }
                stringBuilder.append("]");
            }
            stringBuilder.append("}");
        }
        stringBuilder.append("]");
        return  stringBuilder.toString();
    }

    private List<TreeNode> getAllMenus(List<Menu> menuList, List<TreeNode> treeNodeList) {
        for (Menu menu : menuList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(menu.getId());
            treeNode.setName(menu.getName());
            List<Menu> menuChildren = menuMapper.listMenuByParentId(menu.getId());
            treeNode = getChildNodes(treeNode,menuChildren);
            if (menu.getPid() == 0) {
                treeNodeList.add(treeNode);
            }

            if(menuChildren.size() > 0) {
                getAllMenus(menuChildren,treeNodeList);
            }
        }
        return treeNodeList;
    }


    private TreeNode getChildNodes(TreeNode treeNode,List<Menu> menuList) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        for(Menu menu : menuList) {
            TreeNode childNode = new TreeNode();
            childNode.setId(menu.getId());
            childNode.setName(menu.getName());
            treeNodeList.add(childNode);
        }
        treeNode.setChildCity(treeNodeList);
        return treeNode;
    }

}
