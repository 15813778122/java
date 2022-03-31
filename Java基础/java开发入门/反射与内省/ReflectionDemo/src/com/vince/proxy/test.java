package com.vince.proxy;

import org.junit.Test;

public class test {

    @Test
    public void testProxy(){
        CreateProxy cp = new CreateProxy();//用来创建代理对象的对象
        Hotel person = new Person();
        Hotel proxy = ((Hotel) cp.create(person));
        //proxy.shopping();
        proxy.reserve();
    }
}
