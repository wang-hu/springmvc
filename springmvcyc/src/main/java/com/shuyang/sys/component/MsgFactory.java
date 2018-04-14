package com.shuyang.sys.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class MsgFactory {

    @Autowired
    MessageSource messageSource;

    public Msg successMsg(String message) {
        return new Msg(message,true);
    }

    public Msg successMsg(String message,Object object) {
        return new Msg(message,true,object);
    }

    public Msg successMsg(String message, Object object, Locale locale, Object...args) {
        String msg = messageSource.getMessage(message,args,locale);
        return new Msg(msg,true,object);
    }

    public Msg failMsg(String message) {
        return new Msg(message,false);
    }

    public Msg failMsg(String message,Object object) {
        return new Msg(message,false,object);
    }

    public Msg failMsg(String message, Object object, Locale locale, Object...args) {
        String msg = messageSource.getMessage(message,args,locale);
        return new Msg(msg,true,object);
    }
}
