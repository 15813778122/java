package com.vince.singleton;

import java.io.Serializable;

/**
 * 单例模式
 * 1.多线程访问的安全问题
 * 2.加上volatile关键字保证变量的一致性,防止编译器可能优化读取和存储，可能暂时使用寄存器中的值
 * 3.防止反射调用私有构造方法
 * 4.让单例类可以被序列化
 */

public class Singleton implements Serializable {
    private volatile static Singleton singleton = null;
    private Singleton(){
        if(singleton!=null){
            throw new RuntimeException("此类对象为单例模式，已经被实例化");
        }
    }

    public static Singleton getInstance(){
        if(singleton == null){ // 外面的这层判断是防止已经new过了
            synchronized (Singleton.class){ //利用类作为锁，锁这个当前对象
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
