package com.leecode.medium;

/**
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 */
public class FindMaximumXOR421 {
    // 时间复杂度为o(n^2)的算法
    public static int findMaximumXOR(int[] nums) {
        if (nums.length < 2) return 0;
        int max = -1;
        for (int i = 0;i < nums.length;i++){
            for (int j = i+1;j < nums.length;j++){
                max = Math.max(max,nums[i]^nums[j]);
            }

        }
        return max;
    }
    // 时间复杂度为o(n)的算法
    public static int findMaximumXOR2(int[] nums) {
        if (nums.length < 2) return 0;
        int max = -1;
        for (int i = 0;i < nums.length;i++){
            for (int j = i+1;j < nums.length;j++){
                max = Math.max(max,nums[i]^nums[j]);
            }

        }
        return max;
    }

    public static void main(String[] args) {
       int[] nums = {3,10,5,25,2,8};
//       int[] nums = {4,6,7};
        System.out.println(findMaximumXOR(nums));
    }
}
