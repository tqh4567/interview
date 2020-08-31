package com.newcode;

import java.util.*;

public class Main {
    private static int count = 0;
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long ph = scanner.nextLong();
//        long normalAttack = scanner.nextLong();
//        long buffedAttack = scanner.nextLong();
//        System.out.println(getTimes(normalAttack, buffedAttack, ph));
        System.out.println(getTimes(27604604, 87800967, 694729965));

    }
    public static long getTimes(long normalAttack,long buffedAttack,long ph){
        if (ph == 0) return 0;
        long result;
        if (buffedAttack > normalAttack * 2){
            long res = ph % buffedAttack;
           if (res > 0 && res <= normalAttack){
                result = 2 * ph / buffedAttack + 1;
            }else {
                result =  ( (ph-1) / buffedAttack)*2 + 2;
            }
        }else {
            long res = ph % normalAttack;
            if (res == 0){
                result = ph / normalAttack;
            }else {
                result = ph / normalAttack+1;
            }
        }
        return result;
    }
    public static int plans(int[] nums, int target){
        if (target < 0 || nums.length < 1) return 0;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backTracking(nums,list,0,target);

        return count;
    }

    private static void backTracking(int[] nums, LinkedList<Integer> list, int start, int target) {
        if (target < 0) return;
        if (target == 0){
            count++;
            return;
        }
        for (int i = start;i < nums.length;i++){
            if (nums[i] > target){
                continue;
            }
            list.add(nums[i]);
            backTracking(nums, list, i, target-nums[i]);
            list.removeLast();
        }
    }
}
