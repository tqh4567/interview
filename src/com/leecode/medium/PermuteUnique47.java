package com.leecode.medium;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique47 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 1) return res;
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(0,nums,list,used);
        return res;
    }

    private void dfs(int begin, int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (begin == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (used[i]){
                continue;
            }
            // 下面的剪枝很关键
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(begin+1,nums,list, used);
            used[i] = false;
            list.removeLast();
        }

    }
    /*
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums,0, used, path);
        return res;
    }

    private void dfs(int[] nums, int depth, boolean[] used, LinkedList<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, depth + 1, used, path);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }
     */
}
