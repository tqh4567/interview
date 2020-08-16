package com.leecode.easy;

import java.util.Arrays;

public class RunningSum1480 {
    public static int[] runningSum(int[] nums) {
        for (int i = 1;i < nums.length;i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("runningSum(nums) = " + Arrays.toString(runningSum(nums)));
    }

}
