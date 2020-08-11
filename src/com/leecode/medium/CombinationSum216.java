package com.leecode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(n,k,1,list,res);
        return res;
    }

    private void dfs(int target, int k, int begin, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == k && target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = begin;i <= 9;i++){
            if (i > target){
                continue;
            }
            list.add(i);
            dfs(target-i,k,i+1,list,res);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum216 combinationSum = new CombinationSum216();
        System.out.println("combinationSum.combinationSum3(3,7) = " + combinationSum.combinationSum3(3, 9));
    }
}
