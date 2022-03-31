package com.vince.introspector;

import org.junit.Test;

public class BeanTest {
    @Test
    public void getBeanTest(){
        //利用工厂模式来生产bean对象
        Config bean = (Config)BeanFactory.getBean("bean.name");
        System.out.println(bean);
    }
}
