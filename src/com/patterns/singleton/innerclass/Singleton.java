package com.patterns.singleton.innerclass;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 10:45
 * 双重检查机制的
 */
public class Singleton {

    private Singleton(){}

    // 写一个静态内部类，有一个静态属性singleton
    private static class SingletonInstance{
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.SINGLETON;
    }

}
