package com.vince;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    @Test
    public void test3(){
        String s = "212313";
        boolean b1 = s.matches("[0-9]+");
        boolean b2 = s.matches("\\d+");
        System.out.println(b1+"-"+b2);
    }

    @Test
    public void test2(){
        //创建一个匹配模式(模板)
        Pattern p = Pattern.compile("a*b");
        Matcher matcher = p.matcher("aab");
        boolean b = matcher.matches();//是否匹配的意思
        System.out.println(b);
    }

    /**
     * 没有使用正则表达式来检查字符串是否由数字组成
     */
    @Test
    public void test1(){
        String s = "5201324";
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]<'0' || chars[i]>'9'){
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("都是数字");
        } else {
            System.out.println("不都是数字");
        }
    }
}
