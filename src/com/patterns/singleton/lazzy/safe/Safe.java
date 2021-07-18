package com.patterns.singleton.lazzy.safe;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 10:06
 */
public class Safe {

}

/**
 * 懒汉式2 -- 线程安全
 * 实际开发能使用，线程安全,但是每次获得实例对象都需要同步，效率低下
 * 在实际开发中不推荐
 */
class Singleton1{
    private static Singleton1 instance;

    private Singleton1(){}
    // synchronized同步处理 线程安全
    public static synchronized Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 懒汉式3 --针对懒汉式3进行改进，虽然解决效率低下的问题但是--线程不安全
 * 实际开发禁止使用，线程不安全
 */
class Singleton2{
    private static Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        // 线程不安全
        if (instance == null) {
            // synchronized 同步在此不起作用
            synchronized (Singleton2.class) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
}
