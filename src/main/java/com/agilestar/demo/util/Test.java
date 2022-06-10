package com.agilestar.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description:
 * @author: yangzhenyu
 * @date: 2022年06月06日 10:32
 */
public class Test {
    public static void main(String[] args) {

        String str = "安宁";
        char[] c = str.toCharArray();
        List<String> list = new ArrayList<String>(); //定义对象依次存放每一个字符
        for (int i = 0; i < c.length; i++) {
            String ss = String.valueOf(c[i]);
            System.out.println(ss);
            list.add(ss);
        }
        System.out.println(list.toString());
        System.out.println("1111");
        System.out.println("222");
    }
}
