package com.leecode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *[3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6]
 * 10
 */
public class TopKFrequent347 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.println("topKFrequent(nums,2) = " + Arrays.toString(topKFrequent(nums, 10)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) return nums;
        int[] result = new int[k];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0,j = i+1;
        while (i < nums.length){
            List<Integer> list = new ArrayList<>();
            while (j < nums.length && nums[j] == nums[i]){
                j++;
            }
            list.add(nums[i]);
            list.add(j-i);
            res.add(list);
            i = j;
            j = j+1;
        }
        res.sort((o1, o2) -> o2.get(1) - o1.get(1));
        for (int m = 0;m < k;m++){
            result[m] = res.get(m).get(0);
        }
        return result;
    }
}
