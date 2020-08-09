package com.leecode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets78 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(0,nums,list);
        return res;
    }

    private void dfs(int start, int[] nums, LinkedList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start;i < nums.length;i++){
            list.add(nums[i]);
            dfs(i+1,nums,list);
            list.removeLast();
        }
    }
}
