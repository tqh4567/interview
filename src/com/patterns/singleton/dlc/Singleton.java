package com.patterns.singleton.dlc;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 10:45
 * 双重检查机制的
 */
public class Singleton {
    // volatile ： 轻量级的同步机制保证可见性；禁止指令重排，避免构造方法指令重排，避免新对象指向未初始化的值
    private static volatile Singleton singleton;

    private Singleton (){}

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                // 保证单例
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
