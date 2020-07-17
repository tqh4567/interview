package com.leecode.easy;

public class MaxSubArray53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int res = f[0];
        for (int i = 1;i < n;i++){
            f[i] = Math.max(nums[i],f[i-1]+nums[i]);
            f[i-1] = f[i];
            res = Math.max(f[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-2,-1};
        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));
    }
}
