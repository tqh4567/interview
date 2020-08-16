package com.leecode.medium.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 *  说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsWithDup90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length <= 0) return res;
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        dfs(0,nums,list);
        return res;
    }

    private void dfs(int start, int[] nums, LinkedList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start;i < nums.length;i++){
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            dfs(i+1,nums,list);
            list.removeLast();
        }
    }
}
