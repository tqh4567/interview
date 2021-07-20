package com.study.designpattern.singleton;

/**
 * ====静态内部类====
 * 采用类的装载机制来保证初始化的时候只有一个线程（jvm帮我们保证线程安全，类初始化时别的线程无法进入）
 * 静态内部类在SingletonStatic类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会去装载，从而实现懒加载
 *
 * 线程安全，实现懒加载
 * ****可以使用，推荐****
 */
public class SingletonStatic {
    private SingletonStatic(){}
    private static class SingletonInstance{
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }
    // 提供公有方法，返回单例
    public static SingletonStatic getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
