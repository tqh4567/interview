package com.study.customer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(()->{
            for(int i = 1;i<=5;i++){
                try {
                    queue.put(i);
                    System.out.println("添加" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i = 1;i<=5;i++){
                try {
                    queue.take();
                    System.out.println("取出" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

//        ShareDatas shareDatas = new ShareDatas();
//        for(int i = 1;i<=5;i++){
//            new Thread(()->{
//                shareDatas.product();
//            },String.valueOf(i)).start();
//        }
//        for(int i = 1;i<=5;i++){
//            new Thread(()->{
//
//                shareDatas.consume();
//            },String.valueOf(i)).start();
//        }
    }

}
// 资源类
class ShareDatas{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();
    // 生产
    public void product(){
        lock.lock();
        try{
            while(number != 0){
                // 证明有商品，可以进行消费
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("开始生产商品了。。。" + number);
            number+=1;
            condition2.signal();
        }catch (Exception ex){

        }finally {
            lock.unlock();
        }

    }
    public void consume(){
        lock.lock();
        try {
            while(number!=1){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number-=1;
            System.out.println("开始消费商品了" + number);
            condition.signal();
        }catch (Exception ex){

        }finally {
            lock.unlock();
        }


    }
}
