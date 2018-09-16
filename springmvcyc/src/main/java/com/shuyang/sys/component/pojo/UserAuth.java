package com.shuyang.sys.component.pojo;

import lombok.Data;

@Data
public class UserAuth {
    private String loginName;
    private String userPassword;
    private String authority;

}
