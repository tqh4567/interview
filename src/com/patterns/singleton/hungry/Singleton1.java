package com.patterns.singleton.hungry;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 9:37
 * 静态常量的饿汉式单例模式
 */
public class Singleton1 {
    /**
     * 私有化构造器，防止外部通过new（）进行创建
     */
    private Singleton1(){};

    // 内部创建一个对象实例
    private final static Singleton1 instance = new Singleton1();

    // 提供一个公共的获取实例的方法
    public static Singleton1 getInstance(){
        return instance;
    }
}
