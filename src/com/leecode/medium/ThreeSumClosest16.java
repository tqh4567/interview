package com.leecode.medium;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static int threeSumClosest(int[] nums, int target) {
        // 暴力直接通过了
        /*
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int frist = 0,second = 0,third = 0;
        for (int i = 0;i < n - 2;i++){
            for (int j = i+1;j < n-1;j++){
                for (int k = j+1;k< n;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if (min > Math.abs(target - sum)){
                        min = Math.min(min,Math.abs(target-sum));
                        frist = i;
                        second =j;
                        third = k;
                    }

                }
            }
        }
        return nums[frist] + nums[second] + nums[third];
        */
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < n-1; i++){
            int j = i+1; int k = n-1;
            while (j < k){
               int  sum = nums[i] + nums[j] + nums[k];
               if (Math.abs(target - sum) < Math.abs(target - res)){
                   res = sum;
               }
               if (sum > target){
                   k--;
               }else if (sum < target){
                   j++;
               }else {
                   return res;
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println("threeSumClosest(nums,1) = " + threeSumClosest(nums, 1));
    }
}
