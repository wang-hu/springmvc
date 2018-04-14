package com.shuyang.sys.domain.component;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode {
    Integer id;
    Integer pid;
    String url;
    String icon;
    String name;
    List<TreeNode> childCity;
}
