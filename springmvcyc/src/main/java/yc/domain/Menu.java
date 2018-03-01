package yc.domain;

import lombok.Data;

import java.util.List;

/**
 * @author wh
 * @date 2018-03-01 10:23
 */
@Data
public class Menu {
    private Integer id;

    private String text;

    private String url;

    private Integer menuOrder;

    private Integer parentId;

    private String state;

    private boolean checked;

    private List<Menu> children;

    private String attributes;
}