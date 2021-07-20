package com.study.designpattern.singleton;

/**
 * ======双重检查=======
 * 解决线程安全问题，可以实现懒加载，解决效率问题
 * *****推荐使用******
 */
public class SingletonDoubleCheck {
}
class SingletonDouble {
    // volatile 实现可见性与禁止指令重排
    private static volatile SingletonDouble singleton;

    // 构造方法私有化，禁止外部通过new进行创建
    private SingletonDouble(){

    }
    public static SingletonDouble getInstance(){
        if (singleton == null){
            synchronized (SingletonDouble.class){
                if (singleton == null){
                    singleton = new SingletonDouble(); // volatile 可以避免singleton 指向未赋值的对象
                }
            }
        }
        return singleton;
    }
}
