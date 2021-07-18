package com.patterns.singleton.enume;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : TianQingHai
 * @create 2021/7/18 11:42
 * 线程安全，而且还能防止反序列化重新创建对象
 * 在开发过程中建议使用
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance2 == instance);
        System.out.println(instance2.hashCode() + "    " + instance.hashCode());
    }
}
