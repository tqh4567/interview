package com.leecode.easy;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 */
public class ValidMountainArray941 {
    public static void main(String[] args) {
        int[] nums = {9,5,4};
        System.out.println("validMountainArray(nums) = " + validMountainArray(nums));
    }
    public static boolean validMountainArray(int[] A) {
        int n = A.length;
        if(n < 3) return false;
        int left = 0,right = n-1;
        for(int i = 1;i < n;i++){
            if(A[i] <= A[i-1]){
                left = i-1;
                break;
            }
        }
        for(int i = n-1;i > 0;i--){
            if(A[i] >= A[i-1]){
                right = i;
                break;
            }
        }
        return left == right;
    }
}
