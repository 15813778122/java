package com.qfedu.ioc.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class test2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String clazzPath = "com.qfedu.ioc.bean.Book";
        Class<?> book = Class.forName(clazzPath);
        Object o = book.newInstance();

        Field[] fields = book.getDeclaredFields();
        for (Field f: fields){
            String name = f.getName();
            String setMethodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
            if("setName".equals(setMethodName)){
                Method declaredMethod = book.getDeclaredMethod(setMethodName, f.getType());
                declaredMethod.invoke(o,"10001");
            }
        }
        System.out.println(o);

    }
}
