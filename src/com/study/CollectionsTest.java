package com.study;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class CollectionsTest {
    public static void main(String[] args) {
//        int[] ints = {0, 0, 0, 0, 0, 0};
        List<String> list = new ArrayList<>();
        list.add("1_");
        list.add("b");
        list.add("c");
        list.add("1_");
        list.add("1_");
        list.add("5_");
        List<String> fromList = deleteElementFromList(list, "1_");
        for (String el : fromList){
            System.out.println("el = " + el);
        }
    }
    public static List<String> deleteElementFromList(List<String> list,String target){
        /**
         * 增强for循环,对于有多个相同值的target，会抛出{@link java.util.ConcurrentModificationException}
         */
        for (String element : list){
            if (target.equals(element)){
                list.remove(element);
            }
        }
        /**
         * 普通for循环
         * 由于不是线程安全的，删除后元素前移，但是i没有回退，造成漏删
         * el = b
         * el = c
         * el = 1_  没有删掉
         * el = 5_
         */
//        for (int i = 0;i < list.size();i ++){
//            if (target.equals(list.get(i))){
//                list.remove(list.get(i));
//            }
//        }
        /**
         * 采用迭代器删除
         */
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if (target.equals(iterator.next())){
//                iterator.remove();    //正确
//                list.remove(iterator.next());  // 依然会抛出{@link java.util.ConcurrentModificationException}
//            }
//        }
        /**
         * 采用removeIf()
         */
//        list.removeIf(target::equals);
        /**
         * 线程安全集合{@link java.util.concurrent.CopyOnWriteArrayList}
         * 采用 List<String> list1 = Collections.synchronizedList(list);转换为线程安全的list（性能要比CopyOnWriteArrayList差些）
         */
//        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(list);
//        for (String str : cowList) {
//            if (target.equals(str)) {
//                cowList.remove(str);
//            }
//        }
//        return cowList;
        return list;
    }
    public static List<List<Integer>> getThreeNumber(int[] nums){
        Arrays.sort(nums);
        boolean flag = true;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < n;i++){
            List<Integer> l1 = new ArrayList<>();
            for(int j = i+1;j < n;j++){
                int target = -(nums[i] + nums[j]);
                int i1 = findNums(nums, j + 1, n - 1, target);
                if(i1>=0&&nums[i1] == nums[i] && flag){
                    l1.add(nums[i]);
                    l1.add(nums[j]);
                    l1.add(nums[i1]);
                    result.add(l1);
                    flag = false;
                    break;
                }
                if(i1 >= 0 && flag ){
                    if (set.contains(nums[j])){
                        continue;
                    }else {
                        l1.add(nums[i]);
                        l1.add(nums[j]);
                        l1.add(nums[i1]);
                        result.add(l1);
                        set.add(nums[j]);
                        break;
                    }
                }
            }
        }
        return result;
    }
    private static int findNums(int[] nums,int m,int n,int target){

        while(m <= n){
            int mid = (m+n)/2;
            if(nums[mid]>target){
                n = mid -1;
            }else if (nums[mid] < target){
                m = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static Boolean isOnceEdit(String s1,String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int i = 0,j = 0;
        int count = 0;
        if (Math.abs(length1-length2) > 1){
            return false;
        }
        if (length1 > length2){
            while (i <length1 && j <length2){
                if (s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else {
                    i++;
                    count++;
                }
                i++;
                j++;
            }
            return count <= 1;
        }else if (length1 < length2){
            while (i <length1 && j <length2){
                if (s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else {
                    j++;
                    count++;
                }
                i++;
                j++;
            }
            return count <= 1;
        }else {
            while (i <length1 && j <length2){
                if (s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else {
                    count++;
                    i++;
                    j++;
                }
            }
            return count == 1;
        }
    }
}
