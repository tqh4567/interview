package com.study.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 固定大小线程池
//        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 只有一个线程的线程池
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 创建含有n个线程的线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 15; i++) {
                int finalI = i;
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "   id " + finalI);
                });
            }
        }catch (Exception ex){
            System.out.println("发生异常 ex = " + ex);
        }finally {
            executor.shutdown();
        }


    }
}
