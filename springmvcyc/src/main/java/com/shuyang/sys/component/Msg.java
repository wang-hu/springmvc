package com.shuyang.sys.component;

import lombok.Data;

@Data
public class Msg {
    private String msg;
    private boolean success;
    private Object object;

    public Msg() {
        success = true;
    }

    public Msg(String msg) {
        this.msg = msg;
    }

    public Msg(String msg, boolean success) {
        this(msg);
        this.success = success;
    }

    public Msg(String msg, Object object) {
        this.msg = msg;
        this.object = object;
    }

    public Msg(String msg, boolean success, Object object) {
        this(msg, success);
        this.object = object;
    }
}
