package com.vince;

import org.junit.Test;

public class RegexDemo2 {
    @Test
    public void test(){
        //匹配电话号码
        String phoneNumber = "010-23234565";
        System.out.println(phoneNumber.matches("\\d{3,4}-\\d{7,8}"));
        //匹配手机号码
        String phone = "12343426212";
        System.out.println(phone.matches("[1][3-9]\\d{9}"));
        //匹配用户名：字母开头，数字字母下划线组合
        String username = "abc1234";
        System.out.println(username.matches("[a-zA-Z]+[\\w|_]"));
        //匹配IP地址
        String ip = "20.10.20.123";
        System.out.println(ip.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
        //匹配网址
        String addr = "http://www.baidu.com";
        System.out.println(addr.matches("http://\\w+.\\w+.\\S*"));
    }
}
