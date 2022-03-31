package com.qfedu.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Component声明spring容器管理此类 @Aspect声明为切面类
@Component
@Aspect
public class TransactionManger {
    // 定义切入点
    @Pointcut("execution(* com.qfedu.dao.*.*(..))")
    public void pc1(){}
    //配置通知策略（前置）
    @Before("pc1()")
    public void begin(){
        System.out.println("-----开启事务");
    }
    // (后置)
    @After("pc1()")
    public void commit(){
        System.out.println("-----提交事务");
    }
    // (环绕)
    public Object printExecuteTime(ProceedingJoinPoint point) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object v = point.proceed();
        long time2 = System.currentTimeMillis();
        System.out.println("----time"+(time2-time1));
        return v;
    }
}
