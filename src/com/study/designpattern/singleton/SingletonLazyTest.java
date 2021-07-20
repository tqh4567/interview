package com.study.designpattern.singleton;

public class SingletonLazyTest {
}

/**
 * ======线程不安全======
 * 可以起到懒加载的效果，但是只能在单线程下使用
 * 如果A线程判断了singleton == null为true但是此时被挂起，线程B也走到此处正常执行，创建一个实例；
 * 此时A又执行了，又创建了一个实例，所以说线程不安全。
 * **结论**
 *  开发中不要使用这种模式，只能在单线程中使用，（多线程下会创建多个实例，不是单例了）
 */
class Singleton3{
    private static Singleton3 singleton;
    private Singleton3(){

    }
    // 提供静态方法，当使用时就去创键
    public static Singleton3 getInstance(){
        if (singleton == null){
            singleton = new Singleton3();
        }
        return singleton;
    }
}

/**
 * ======线程安全，同步方法======
 * 解决了线程不安全问题
 * 效率太低了，每个线程想要获取实例的时候，执行getInstance（）都要进行线程同步。
 * 而其实这个方法只要执行一次实例化代码就行了，后面想实例化直接返回就行了，每次都同步效率太低了。
 *  ****在开发中不要使用这种方法*******
 */
class Singleton1{
    private static Singleton1 singleton;
    private Singleton1(){

    }
    // 加入同步代码，解决线程不安全问题
    public static synchronized Singleton1 getInstance(){
        if (singleton == null){
            singleton = new Singleton1();
        }
        return singleton;
    }
}
/**
 * ======线程安全，同步代码块======
 * 不能解决了线程不安全问题
 *  ****在开发中不要使用这种方法*******
 */
class Singleton2{
    private static Singleton2 singleton;
    private Singleton2(){

    }
    // 加入同步代码，解决线程不安全问题
    public static Singleton2 getInstance(){
        if (singleton == null){ // 线程不安全，创建多个实例
            synchronized(Singleton2.class) {
                singleton = new Singleton2();
            }
        }
        return singleton;
    }
}
