package com.study.lock;

import java.util.concurrent.TimeUnit;

class LockThread implements Runnable{
    private  String lockA;
    private  String lockB;

    public LockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"拿到了 \t" + lockA+"\t尝试去拿lockB");
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"拿到了\t " + lockB);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new LockThread(lockA,lockB),"A").start();
        new Thread(new LockThread(lockB,lockA),"B").start();
    }
}

