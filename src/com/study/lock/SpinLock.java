package com.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 不可重入自旋锁，如代码：AAA线程获得了锁对象，没有释放，此时再用BBB线程去获取自旋锁，不能拿到新的锁对象
 *
 * 如何改为可重入自旋锁？{@link ReentrySpinLock}
 *
 */
public class SpinLock {

    AtomicReference<Thread> reference = new AtomicReference<>();
    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            spinLock.unlock();
        },"AAA").start();
        // 暂停1s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            spinLock.lock();
            spinLock.unlock();
        },"BBB").start();
    }
    public void lock(){
        System.out.println(Thread.currentThread().getName()+"正在进入。。。。");
        // 加锁
        Thread current = Thread.currentThread();
        while(!reference.compareAndSet(null,current)){

        }
    }
    public void unlock(){
        // 解锁
        Thread current = Thread.currentThread();
        reference.compareAndSet(current,null);
        System.out.println(Thread.currentThread().getName()+"正在解锁。。。。");
    }
}
