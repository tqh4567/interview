package com.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 可重入自旋锁
 *设计思想：引入一个计数器count，用于计数获得锁的线程，如果当前线程获得了锁，计数器的值+1，然后返回；否则进行自旋。
 *         解锁之前先去判断count值是否大于0，大于0，表示当前线程已经获得了该锁，count--，解锁
 */
public class ReentrySpinLock {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();
    private static int count = 0;
    public static void main(String[] args) {
        ReentrySpinLock spinLock = new ReentrySpinLock();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.myLock();

//            spinLock.unlock();
        },"AAA").start();
        // 暂停1s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            spinLock.myLock();
            spinLock.myUnLock();
        },"BBB").start();
    }
    public void myLock(){
        Thread current = Thread.currentThread();
        if(current == atomicReference.get()){
            count++;
            System.out.println(Thread.currentThread().getName()+"自加计数器count。。。。");
            return;
        }else {
            // 没有获得锁，自旋
            System.out.println(Thread.currentThread().getName()+"正在进入。。。。");
            while (atomicReference.compareAndSet(null,current)){

            }
        }
    }
    public void myUnLock(){
        Thread current = Thread.currentThread();
        if(current==atomicReference.get()){
            if(count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"自减计数器count。。。。");
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"正在解锁。。。。");
            atomicReference.compareAndSet(current,null);
        }

    }
}
