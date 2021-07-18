package com.patterns.singleton.lazzy.unsafe;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 10:06
 * 懒汉式1 -- 线程不安全
 * 实际开发不能使用，线程不安全
 */
public class UnSafe {
}
class Singleton{
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        // 线程不安全
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
