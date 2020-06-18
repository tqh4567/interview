package com.study.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 编写一个程序，有5个线程，使得main线程在这五个线程之后执行
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
//        AtomicInteger number = new AtomicInteger(5);
        int number = 5;
        CountDownLatch countDownLatch = new CountDownLatch(number);
        for(int i=1;i<=5;i++){
            int finalI = i;
            new Thread(()->{
//                number.decrementAndGet();
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+ finalI +"执行了！");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)) .start();

        }
        // 前面的线程未执行完就等待
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"执行了！");
    }
}
