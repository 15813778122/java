package com.vince.aop;

import org.junit.Test;

import java.io.InputStream;

public class AOPTest {
    @Test
    public void test(){
        //1.读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/aop/bean.properties");
        //2.创建Bean的工厂模式
        BeanFactory beanFactory = new BeanFactory(in);
        //3.获取代理对象
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)beanFactory.getBean("bean");
        IManager proxy = (IManager)proxyFactoryBean.getProxy();
        proxy.add("我是一只猫");
    }
}
