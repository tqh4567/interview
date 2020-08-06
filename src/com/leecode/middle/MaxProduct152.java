package com.leecode.middle;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct152 {
    // 暴力解法，简单易懂
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0;i < n; i++){
            int plus = nums[i];
            if(nums[i] == 0){
                plus = 1;
            }
            for (int j = i+1;j < n;j++){
                plus *= nums[j];
                res = Math.max(plus,Math.max(nums[i],Math.max(nums[j],res)));
            }
        }
        return res;
    }
    // 动态规划
    // 记录正数的乘机最大值与负数的乘最小值，计算乘
    public static int maxProduct2(int[] nums) {
        int prevMin = nums[0], prevMax = nums[0], res = nums[0];
        int temp1 = 0, temp2 = 0;
        for (int i = 1; i < nums.length; i++) {
            temp1 = nums[i] * prevMax;
            temp2 = nums[i] * prevMin;
            prevMax = Math.max(Math.max(temp1, temp2), nums[i]);
            prevMin = Math.min(Math.min(temp1, temp2), nums[i]);
            res = Math.max(res, prevMax);
        }
        return res;
    }

    /**
     * int n = nums.length;
     *         int max = Integer.MIN_VALUE;
     *         for (int j = 0;j<n-1;j++) {
     *             int[] dp = new int[n];
     *             dp[0] = nums[j];
     *             int res = dp[0];
     *             for (int i = j+1; i < n; i++) {
     *                 dp[i] = dp[i - 1] * nums[i];
     * //            if (nums[i] == 0){
     * //                dp[i] = dp[i-1];
     * //            }else if(nums[i] > 0 ) {
     * //                if (dp[i-1] < 0 || min <0){
     * //                    min = dp[i-1]*nums[i];
     * //                    dp[i] = nums[i];
     * //                }else {
     * ////                dp[i] = Math.max(dp[i - 1], dp[i - 1] * nums[i]);
     * //                    dp[i] = Math.max(dp[i - 1], dp[i - 1] * nums[i]);
     * //                }
     * //            }else {
     * //                dp[i] = Math.max(min*nums[i],res);
     * //            }
     *                 res = Math.max(dp[i - 1], Math.max(dp[i], Math.max(nums[i], res)));
     *             }
     *             max = Math.max(res,max);
     *         }
     *         return max;
     * @param args
     */
    public static void main(String[] args) {
        int[] nums={3,-1,4};
        System.out.println("maxProduct(nums) = " + maxProduct2(nums));
    }
    public class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
}
