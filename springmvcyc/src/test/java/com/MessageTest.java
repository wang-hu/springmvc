package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

/**
 * @author:wh
 * @create in 18-3-22 下午3:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring.xml",
        "classpath:spring-mvc.xml",
        "classpath:spring-mybatis.xml"})
public class MessageTest {

    @Autowired
    MessageSource messageSource;
    @Test
    public void test() {
        String string = "{0}今天要去{1}吃饭";
        String[] args = {"王东","学校"};
        Locale locale = new Locale(Locale.CHINESE.getLanguage(),Locale.CHINA.getCountry());
        String s = messageSource.getMessage(string, args, string, locale);
        System.out.println(s);
    }
}
