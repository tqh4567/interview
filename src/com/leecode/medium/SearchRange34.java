package com.leecode.medium;

public class SearchRange34 {
    public static int[] searchRange(int[] nums, int target) {
        int i = 0 , j = nums.length-1;
        int max = -1,min = -1;
        int mid = (i+j)/2;
//        while(i <= j){
//
//            if(nums[mid] > target){
//                j = mid-1;
//            }else if(nums[mid] < target){
//                i = mid + 1;
//            }else{
//                max = getMaxIndex(nums,mid,nums.length-1,target);
//                min = getMinIndex(nums,mid,nums.length-1,target);
//            }
//        }
        if(nums[mid] < target){
            min = getMinIndex(nums,mid+1,nums.length-1,target);
            max = getMaxIndex(nums,mid+1,nums.length-1,target);
        }else if (nums[mid] > target){
            min = getMinIndex(nums,0,mid-1,target);
            max = getMaxIndex(nums,0,mid-1,target);
        }else {
            max = Math.max(mid,getMaxIndex(nums,mid+1,nums.length-1,target));
            min = Math.min(mid,getMinIndex(nums,0,mid-1,target));
        }


        if (min == -1 && max != -1){
            min = max;
        }
        if (min != -1 && max == -1){
            max = min;
        }
        return new int[]{min,max};
    }
    public static int getMaxIndex(int[] nums,int begin,int end,int target){
        int max = -1;
        while (begin <= end){
            int mid = (begin + end) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            }else if (nums[mid] < target){
                begin = mid + 1;
            }else {
                max = Math.max(max,mid);
                begin = mid + 1;
            }
        }
        return max;
    }
    public static int getMinIndex(int[] nums,int begin,int end,int target){
        int min = end + 1;
        int tem = end;
        while (begin <= end){
            int mid = (begin + end) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            }else if (nums[mid] < target){
                begin = mid + 1;
            }else {
                min = Math.min(min,mid);
                end = mid - 1;
            }
        }
        return min == tem+1? -1 : min;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,7,8,8,10};
        System.out.println("getMaxIndex(nums,0,5,7) = " + getMaxIndex(nums, 0, 5, 5));
        System.out.println("getMaxIndex(nums,0,5,7) = " + getMinIndex(nums, 0, 5, 5));
//        for (int num:searchRange(nums,8)){
//            System.out.println("num = " + num);
//        }
    }
}
