package com.study.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(8);

        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{

            System.out.println("准备好了");

        });

        for (int i = 1; i <=8; i++) {

            final int temp = i;

            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t 运动员"+ temp +"准备好了");
                countDownLatch.countDown();

                try {

                    cyclicBarrier.await();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                } catch (BrokenBarrierException e) {

                    e.printStackTrace();

                }

            },String.valueOf(i)).start();

        }
        countDownLatch.await();
        System.out.println("开跑");
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(8,()->{

            System.out.println("全都通过终点");

        });

        for (int i = 1; i <=8; i++) {

            final int temp = i;

            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t 运动员"+ temp +"到达终点");

                try {

                    cyclicBarrier2.await();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                } catch (BrokenBarrierException e) {

                    e.printStackTrace();

                }

            },String.valueOf(i)).start();

        }

    }
}
