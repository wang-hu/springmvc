package com.shuyang.sys.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wh
 * @date 2018-03-01 10:23
 */
@Data
public class Menu {
    private Integer id;

    private String name;

    private String url;

    private String icon;

    private Integer menuOrder;

    private Integer pid;

    private String state;

    private boolean checked;

    private List<Menu> children;

    private String attributes;

    private Date applyDate;

    private String applyUser;

}