package com.study.designpattern.singleton;
// 单例饿汉式
public class SingletonHungryTest {

    public static void main(String[] args) {
        SingletonHungry singletonHungry = SingletonHungry.getSingleton();
        SingletonHungry singletonHungry2 = SingletonHungry.getSingleton();
        System.out.println(singletonHungry.hashCode());
    }
}

/**
 * 优点：写法简单，在类加载的时候就完成了初始化。避免了线程同步问题
 * 缺点：如果类长时间未调用会产生资源的浪费
 * 这种方式基于classloder机制避免了多线程同步问题，不过，instance在类装载的是后就实例化，
 * 在单例模式下大多数调用getInstance方法，就达不到懒加载的效果。
 * 这种但离模式可以用，可能会造成内存的浪费。RunTime
 */
class SingletonHungry {
    // 构造方法私有化，禁止外部通过new进行创建
    private SingletonHungry(){

    }
    // 本例内部创建实例
    private final static SingletonHungry singleton = new SingletonHungry();

    // 对外提供一个共有的静态方法


    public static SingletonHungry getSingleton() {
        return singleton;
    }
}

/**
 * 静态代码块
 * 和上面的一样，可能会造成资源的浪费
 */
class SingletonHungry1 {
    private static SingletonHungry1 singleton;

    // 静态代码块中进行初始化
    static {
        singleton = new SingletonHungry1();
    }
    // 构造方法私有化，禁止外部通过new进行创建
    private SingletonHungry1(){

    }
    private static SingletonHungry1 getInstance(){
        return singleton;
    }
}
