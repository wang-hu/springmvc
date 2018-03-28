package com.shuyang;

import org.junit.Test;

public class StringTest {

    @Test
    public void stringTest() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }
//编译不通过
    // 无法根据返回类型判断重载方法
//    public void function(int a) {
//
//    }
//
//    public int function(int a) {
//        return 0;
//    }
}
