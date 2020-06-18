package com.study.collection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * capacity：map容量，最多能装多少个元素；size已经装的元素个数
 * 获取当前map的容量，和数据个数
 * 一个方法可以抛出多个异常
 */
public class MapCapacity {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        // 当我们传入的hashmap的值不是2的幂时，hashMap不会采用我们给出的数据作为map的容量，底层会自动将容量设置成大于我们给出容量的2的幂
        // 传入5，其实是8
        Map<String, String> map = new HashMap<String, String>(5);

        map.put("hollis", "hollischuang");

        // 通过反射来获取

        Class<?> mapType = map.getClass();

        Method capacity = mapType.getDeclaredMethod("capacity");
        // 将私有方法设置成可获得，比较暴力
        capacity.setAccessible(true);

        System.out.println("capacity : " + capacity.invoke(map));


        Field size = mapType.getDeclaredField("size");

        size.setAccessible(true);

        System.out.println("size : " + size.get(map));
    }
}
