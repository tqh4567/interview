package com.leecode.middle;

public class Search33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
    public static int searchIndex(int[] nums,int target){
        int i = 0,j = nums.length-1;
        while(i <= j){
            int mid = (i+j)/2;
            if (nums[mid] == target) return mid;
            if(nums[mid] > nums[i]) {
                if (target >= nums[i] && target < nums[mid]){
                    j = mid - 1;
                }else {
                    i = mid + 1;
                }
            }else {
                if (target <= nums[j] && target > nums[mid]){
                    i = mid + 1;
                }else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};
        System.out.println("searchIndex(nums,1) = " + searchIndex(nums, 4));
    }
}
