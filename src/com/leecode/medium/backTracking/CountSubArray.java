package com.leecode.medium.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成一个数列，满足l < a[i]<r,子数组的和要能被3整除
 */
public class CountSubArray {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println("getCountSubArray(array,2) = " + getCountSubArray(array, 2));
    }
    public static int getCountSubArray(int[] array,int len){
        if (array.length == 0) return 0;
        int result = 0;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(array,res,list,0,len);
        for (List<Integer> l : res){
            if (canByThree(l)){
                result++;
            }
        }
        return result;
    }

    private static void backTrack(int[] array, List<List<Integer>> res, LinkedList<Integer> list, int start, int len) {
        if (list.size() == len){
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0;i < array.length; i ++){
            list.add(array[i]);
            backTrack(array,res,list,i,len);
            list.removeLast();
        }
    }
    public static boolean canByThree(List<Integer> list){
        int sum = 0;
        for (int e : list){
            sum += e;
        }
        return sum % 3 == 0;
    }
}
