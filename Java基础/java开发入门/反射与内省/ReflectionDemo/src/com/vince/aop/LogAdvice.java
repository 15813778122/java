package com.vince.aop;

/**
 * 切面的实现类
 */

public class LogAdvice implements Advice{

    @Override
    public void beforeAdvice() {
        System.out.println("add start:"+System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("add end:"+System.currentTimeMillis());
    }
}
