package com.leecode.hard;

import java.util.Arrays;

public class MaxErare84 {
    public static int maxErare(int[] nums){
        if (nums.length < 1) return 0;
        int n = nums.length;
        int max = 0;
        for(int j = 0;j<n;j++){
            int k = 0;
            int count = 0;
            int curMax = 0;
            while (k < n){
                if(nums[k] >= nums[j]){
                    count ++;
                    curMax = Math.max(count,curMax);
                }else {
                    count = 0;
                }
                k++;
            }
            max = Math.max(max,curMax*nums[j]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {200,1,5,6,2,300};
        System.out.println("maxErare() = " + maxErare(nums));
    }

}
