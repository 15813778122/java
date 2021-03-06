package com.vince;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * JDK1.5 线程池
 */

public class ThreadDemo5 {
    public static void main(String[] args) {
        // 创建线程池(4种)
        //1创建一个单线程的线程池
        // ExecutorService es = Executors.newSingleThreadExecutor();
        // 创建一个固定大小的线程池
        // ExecutorService es = Executors.newFixedThreadPool(2);//两个线程会同时走
        /**
         * 创建一个可缓存得线程池。如果线程池的大小超过了处理任务所需要的线程，
         * 那么就会回收部分空闲(60秒不执行任务)的线程，当任务输增加时，此线程池
         * 又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，
         * 线程池大小完全依赖于操作系统(或者说JVM)能够创建的最大线程大小。
         */
        // ExecutorService es = Executors.newCachedThreadPool();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);


//        es.execute(new MyRunnable6());
//        es.execute(new MyRunnable6());

        es.schedule(new MyRunnable6(),3000, TimeUnit.MILLISECONDS);


        es.shutdown();
    }
}

class MyRunnable6 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
