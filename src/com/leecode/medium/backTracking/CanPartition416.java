package com.leecode.medium.backTracking;

import java.util.LinkedList;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 */
public class CanPartition416 {
    boolean res = false;

    public static void main(String[] args) {
        CanPartition416 ca = new CanPartition416();
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println("ca.canPartition(nums) = " + ca.canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        LinkedList<Integer> list = new LinkedList<>();
        backTrac(nums,list,target,0);
        return res;
    }
    public void backTrac(int[] nums, LinkedList<Integer> list, int target, int start){
        if (target < 0){
            return;
        }
        if(target == 0){
            res = true;
            return;
        }
        for(int i = start;i < nums.length;i++){
            if (nums[i] > target){
                continue;
            }
            list.add(nums[i]);
            backTrac(nums, list, target-nums[i], i+1);
            list.removeLast();
        }
    }
}
