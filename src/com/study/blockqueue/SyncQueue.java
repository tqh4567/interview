package com.study.blockqueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 不存储元素的阻塞队列，插入一个元素后，必须得等这个元素出队后，才可以继续插入
 *
 * /**
 * 输出：
 *  * 向队列添加1
 *  * 向队消费加1
 *  * 向队列添加2
 *  * 向队消费加2
 *  * 向队列添加3
 *  * 向队消费加3
 *  */
public class SyncQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println("向队列添加1");
                queue.put(1);
                System.out.println("向队列添加2");
                queue.put(2);
                System.out.println("向队列添加3");
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("向队消费加1");
                queue.take();
                TimeUnit.SECONDS.sleep(5);
                System.out.println("向队消费加2");
                queue.take();
                TimeUnit.SECONDS.sleep(5);
                System.out.println("向队消费加3");
                queue.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

