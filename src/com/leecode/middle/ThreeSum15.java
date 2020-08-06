package com.leecode.middle;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum15 {

    //暴力求解还有三个用例无法通过，超时
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length-2;i++){
            if (nums[i] > 0) break;
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            List<List<Integer>> lists = findTwoSum(nums, i + 1,  - nums[i]);
            for (List<Integer> list:lists){
                if (list.size() == 3){
                    result.add(list);
                }
            }

        }
        return result;
    }
    public  List<List<Integer>> findTwoSum(int[] nums,int index,int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = index; i < nums.length - 1; i++) {
            List<Integer> res = new ArrayList<>();
            int target = sum - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > target) break;
                if (nums[j] == target && !map.containsKey(nums[i])) {
                    map.put(nums[i], nums[j]);
                    res.add(nums[index - 1]);
                    res.add(nums[i]);
                    res.add(nums[j]);
                }
            }
            result.add(res);
        }

        return result;
    }

    // 双指针法
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < nums.length-2;i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;int k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }
                else {
                    j++;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
//        System.out.println("findTwoSum(nums,0,8) = " + threeSum(nums));
    }
}
