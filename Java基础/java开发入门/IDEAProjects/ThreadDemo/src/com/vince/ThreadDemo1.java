package com.vince;

/**
 * 线程的休眠
 * 在当前线程的执行中，暂停指定的毫秒数，释放CPU的时间片
 */

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();//启动线程

        //推荐
        MyRunnable mr = new MyRunnable();
        Thread tr = new Thread(mr);
        tr.start();
    }
}

/**
 * 实现线程的第一种方式：继承Thread类
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * 实现线程的第一种方式：实现Runnable接口
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
