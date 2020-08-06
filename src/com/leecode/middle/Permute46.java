package com.leecode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums,list);
        return res;
    }
    public void dfs(int[] nums,LinkedList<Integer> list){
        // 已经走到底了，将结果加入结果集返回
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            // 如果已经访问过，就跳过
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            // 继续访问下一层
            dfs(nums, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute46 permute  = new Permute46();
        System.out.println("permute.permute(nums) = " + permute.permute(nums));
    }

}
