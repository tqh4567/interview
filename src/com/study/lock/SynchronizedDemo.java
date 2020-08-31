package com.study.lock;

import java.util.concurrent.TimeUnit;

public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(demo::method1, "t1").start();
        new Thread(demo::method2, "t2").start();
    }
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+"进入方法1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+"进入方法2");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
