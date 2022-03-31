package com.vince.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 通过内省的API来装配一个Bean对象，Bean对象的值是通过配置文件中获取
 * 目的是为了提高维护性
 */


public class BeanFactory {
    //1.先创建一个配置文件的对象
    private static Properties prop = new Properties();
    //2.使用静态代码块读取配置文件
    static {
        //这句代码是利用了流来写入到new出来的配置文件对象
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/introspector/config.properties");
        try {
            //3.把配置文件中的信息写入到prop中
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取一个Bean
     * 利用工厂模式来生产不同的bean
     * 目标就是通过调用文件来调用类的属性描述器的set方法，从而获取不同的bean对象
     */
    public static Object getBean(String name){
        Object bean = null;
        //获取到的是com.vince.introspector.Config
        String beanName = prop.getProperty(name);
        try {
            //通过反射来创建类对象
            Class<?> aClass = Class.forName(beanName);
            //创建类实例
            bean = aClass.newInstance();
            //通过类信息获取javaBean的描述信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            //通过javaBean描述信息，获取该类的所有属性描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                //虽然获取到全部的属性描述器，但是不知道名字，这句代码就是获取名字
                String properName = propertyDescriptors[i].getName();
                //获取当前属性描述器的写的方法
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if("username".equals(properName)){
                    //调用属性的set方法，第一个参数是目标对象，第二个参数是方法参数
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                }else if("password".equals(properName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                }else if("url".equals(properName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.url"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
