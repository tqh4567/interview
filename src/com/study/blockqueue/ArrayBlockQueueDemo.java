package com.study.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        try {
            blockingQueue.put(1);
            System.out.println("队列中添加了1");
            blockingQueue.put(2);
            System.out.println("队列中添加了2");
            blockingQueue.put(3);
            System.out.println("队列中添加了3");
            // 添加元素数大于队列长度，添加不进去，系统阻塞,直到铀元素出队后才可以添加
            blockingQueue.put(4);
            System.out.println("队列中添加了4");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("blockingQueue.take() = " + blockingQueue.take());
            System.out.println("blockingQueue.take() = " + blockingQueue.take());
            System.out.println("blockingQueue.take() = " + blockingQueue.take());
            // 当获取超过队列长度的数据时，会等待，进入阻塞，直到队列中又有新的数据插入
            System.out.println("blockingQueue.take() = " + blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * 此方法可以在指定时间内等待，添加恒功返回true，否则返回false
     * boolean offer(E e, long timeout, TimeUnit unit)
     *         throws InterruptedException;
     * 此方法在子定时间内等待获取队列头元素，拿到返回头元素，拿不到返回null
     * E poll(long timeout, TimeUnit unit)
     *         throws InterruptedException;
     */
    public void offerAndPool(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println("blockingQueue.offer(1) = " + blockingQueue.offer(1));
        System.out.println("blockingQueue.offer(1) = " + blockingQueue.offer(2));
        System.out.println("blockingQueue.offer(1) = " + blockingQueue.offer(3));
        // 超过队列长度，返回false
        System.out.println("blockingQueue.offer(1) = " + blockingQueue.offer(4));
        System.out.println("=======================================");

        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        // 超出队列长度，不报错，返回null
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
    }

    /**
     * 演示add与remove方法
     */
    public void addAndRemove(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println("在队列中放入了"+1);
        System.out.println("blockingQueue.add(1) = " + blockingQueue.add(1));
        System.out.println("在队列中放入了"+2);
        System.out.println("blockingQueue.add(2) = " + blockingQueue.add(2));
        System.out.println("在队列中放入了"+3);
        System.out.println("blockingQueue.add(3) = " + blockingQueue.add(3));
        /**
         * 阻塞队列的长度为3，当我们在往里面加入第四个元素时，会报{@link java.lang.IllegalStateException}
         */
//        System.out.println("在队列中放入了"+4);
//        System.out.println("blockingQueue.add(3) = " + blockingQueue.add(4));

        // 获取阻塞队列的头元素
        System.out.println("blockingQueue.element() = " + blockingQueue.element());

        for(int i = 1;i <= 4;i++){
            System.out.println("在队列中取出了第"+i+"元素");
            /**
             * 当队列已经为空，无元素清除时会报{@link java.util.NoSuchElementException}
             */
            System.out.println("blockingQueue.remove(i) = " + blockingQueue.remove());
            /**
             * 不会抛出异常，返回是个boolean值，无元素返回false
             */
            System.out.println("blockingQueue.remove(i) = " + blockingQueue.remove(i));
        }
    }
}
