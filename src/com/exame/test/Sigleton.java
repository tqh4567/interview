package com.exame.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sigleton {
    private static List<List<Integer>> res = new ArrayList<>();
    private static volatile Sigleton sigleton = null;
    public Sigleton getSigleton(){
        if (sigleton == null){
            synchronized (Sigleton.class){
                if (sigleton == null){
                    sigleton = new Sigleton();
                }
            }
        }
        return sigleton;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("fun(nums) = " + fun(nums));

    }
    public static List<List<Integer>> fun(int[] nums){
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums,list,res);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(nums,list,res);
            list.removeLast();
        }
    }

}
