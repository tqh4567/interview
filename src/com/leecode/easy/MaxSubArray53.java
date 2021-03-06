package com.leecode.easy;

public class MaxSubArray53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int res = f[0];
        for (int i = 1;i < n;i++){
            f[i] = Math.max(nums[i],f[i-1]+nums[i]);
//            f[i-1] = f[i];
            res = Math.max(f[i],res);
        }
        return res;
    }
    // 进行状态压缩
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int f0 = nums[0];
        int f1 = 0;
        int res = f0;
        for (int i = 1;i < n;i++){
            f1 = Math.max(nums[i],f0+nums[i]);
            f0 = f1;
            res = Math.max(f1,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2,-1};
        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));
    }
}
