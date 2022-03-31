package com.vince;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.多线程共享数据时，会发生线程不安全的情况
 * 2.多线程共享数据必须使用同步
 * 3.实现同步的三种方法：
 * (1)使用同步代码块
 * (2)使用同步方法
 * (3)使用Lock(更灵活的代码控制)
 * 多线程共享数据，会有安全问题，使用同步可以解决安全问题，但同时会牺牲性能，所以同步的代码块要尽量保持简短，
 * 把不随数据变化的相关代码移除同步块，不要阻塞
 * 在持有锁的时候，不要对其他对象调用同步方法
 */

public class ThreadDemo4 {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t1 = new Thread(mr5);
        Thread t2 = new Thread(mr5);
        t1.start();
        t2.start();
    }
}
class MyRunnable5 implements Runnable{
    private int ticket = 10;//售票
    // private Object obj = new Object(); //同步锁
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
//            if(ticket>0){
//                //synchronized的形参可以是obj或者是this，只要对象是唯一且是同一个就可以
//                synchronized (this) {
//                    ticket--;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("您当前查询的列出的票还剩"+ticket+"张");
//                }
//            }
            method();
        }
    }
    // 同步方法：同步的对象是当前对象(this)
    private synchronized void method(){
        if(ticket>0){
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("您当前查询的列出的票还剩"+ticket+"张");
        }
    }
    //互斥锁
    ReentrantLock lock = new ReentrantLock();
    //Lock实现同步
    private void method2(){
        lock.lock();
        if(ticket>0){
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("您当前查询的列出的票还剩"+ticket+"张");
        }
        lock.unlock();//解锁
    }
}
