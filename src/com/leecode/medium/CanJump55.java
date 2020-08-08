package com.leecode.medium;

public class CanJump55 {
    public static void main(String[] args) {
        int[] nums ={2,3,1,1,4};
        System.out.println("canJump(nums) = " + canJump3(nums));
    }
    // 动态规划
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n-1];
        dp[0] = nums[0];
        for(int i = 1;i < n-1;i++){
            if(nums[i-1] == 0) {
                if (dp[i - 1] < i) return false;
                dp[i] = Math.max(nums[i] + i, dp[i - 1]);
            }else{
                dp[i] = Math.max(nums[i] + i,dp[i-1]);
            }
        }
        for(int j = 0;j<n-1;j++){
            if(dp[j] >= n-1){
                return true;
            }
        }
        return false;
    }
    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        int m = n-1;
        for (int i = m; i >= 0; i--) {
            if (nums[i] >= n-i) {
                n = i;
            }
        }
        return n == 0;
    }


}
