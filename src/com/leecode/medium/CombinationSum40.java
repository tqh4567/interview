package com.leecode.medium;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum40 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length < 1 || target < 0){
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(0,list,candidates,target);
        return res;

    }

    private void dfs(int start, LinkedList<Integer> list, int[] candidates, int target) {
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(list));
        }else {
            for (int i = start;i < candidates.length;i++){
                if (candidates[i] > target){
                    continue;
                }
                /**
                 * 去除重复的元素
                 * 无论是求组合/子集/排列，只要原数组中含有重复元素，通用一个去重方法：
                 * 1.先排序，使相同元素相邻；
                 * 2.在backtrack的for循环里：
                 * 其中i>start一定要理解，i是当前考察的元素下标，start是本层最开始的那个元素的下标，我们的去重是要同层去重，
                 * 如果你只写candidates[i]==candidates[i-1]这一个判断条件，那么在dfs树的时候，身处不同层的相同元素的组合/排列也都生成不了
                 */
                if (i > start && candidates[i] == candidates[i-1]){
                    continue;
                }
                list.add(candidates[i]);
                dfs(i+1,list,candidates,target-candidates[i]);
                list.removeLast();
            }
        }
    }
}
