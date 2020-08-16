package com.leecode.medium.array;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]
 *
 */
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
