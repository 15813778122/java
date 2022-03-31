package com.vince.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 此类用作动态代理
 */

public class ProxyFactoryBean implements InvocationHandler {
    private Object target;
    private Advice advice;

    public Object getProxy(){
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);//com.vince.aop.IManagerImpl@4dcbadb4得到的其实是IManagerImpl的实例
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        advice.beforeAdvice();
        Object obj = method.invoke(target, args);
        advice.afterAdvice();
        return obj;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
