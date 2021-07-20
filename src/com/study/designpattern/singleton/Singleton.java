package com.study.designpattern.singleton;

/**
 * 枚举实现单例
 * 可以实现线程安全，而且开能防止反序列化重建对象问题
 * ***推荐  effective java推荐的方式****
 */
public class Singleton {
    public static void main(String[] args) {
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum1 == singletonEnum2);
    }
}
enum SingletonEnum{
    INSTANCE;
    public void method(){

    }
}
