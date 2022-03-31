package com.vince;

public class ThreadDemo3 {
    public static void main(String[] args) {
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t = new Thread(mr4);
        t.setName("Thread-t");
        //优先级高可以提高该线程抢占CPU时间片的概率大
        t.setPriority(Thread.MAX_PRIORITY);
        // 线程可以分为守护线程和用户线程，当进程中没有用户线程时，JVM会退出
        t.setDaemon(true);//把线程设置为守护线程
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.isAlive());

        for (int i = 0; i < 50; i++) {
            System.out.println("main--"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();//让出本次CPU执行时间片
        }
    }
}
class MyRunnable4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
