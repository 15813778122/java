package com.vince.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanTest {
    @Test
    public void test(){
        //从客户端获取到的数据是这样的
        String name = "bin";
        String age = "18";
        String salary = "10000";

        Emp emp = new Emp();

        try {
            BeanUtils.setProperty(emp,"name",name);
            BeanUtils.setProperty(emp,"age",age);
            BeanUtils.setProperty(emp,"salary",salary);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(emp.getInfo());
    }
}
