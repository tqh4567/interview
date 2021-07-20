package com.leecode.easy;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection349 {
    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {4};
        System.out.println("intersection(nums1,nums2) = " + Arrays.toString(intersection(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int value : nums1) {
            if (set.contains(value)) {
                continue;
            }
            set.add(value);
            if (find(nums2, value)) {
                list.add(value);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static boolean find(int[] nums,int n){
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(n < nums[mid]){
                right = mid - 1;
            }else if(n > nums[mid]){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
