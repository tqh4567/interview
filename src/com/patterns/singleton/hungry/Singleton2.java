package com.patterns.singleton.hungry;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 9:37
 * 静态代码块的饿汉式单例模式
 */
public class Singleton2 {
    public static void main(String[] args) {
        Singleton2 instance = getInstance();
        Singleton2 instance1 = getInstance();
        System.out.println(instance1 == instance);
        System.out.println(instance1.hashCode() + " "+ instance.hashCode());
    }
    /**
     * 私有化构造器，防止外部通过new（）进行创建
     */
    private Singleton2(){};

    // 内部创建一个对象实例
    private static final Singleton2 instance;

    // 通过静态代码块进行实例的创建
    static {
        instance = new Singleton2();
    }

    // 提供一个公共的获取实例的方法
    public static Singleton2 getInstance(){
        return instance;
    }
}
