package com.study;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println("findIndex(nums) = " + findIndex(nums));
    }
    public static int findIndex(int[] nums){
        int n = nums.length;
        if (nums[0] < nums[n-1]){
            return nums[0];
        }
        int i = 0;
        int j = n-1;
        while (i < j){
            int mid = (i + j) / 2;
            if (nums[mid] > nums[j]){
                i = mid+1;
            }else if (nums[mid] < nums[j]){
                j = mid;
            }else {
                j--;
            }

        }
        return nums[i];
    }

}
