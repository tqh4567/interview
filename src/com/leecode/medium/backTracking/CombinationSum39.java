package com.leecode.medium.backTracking;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 */
public class CombinationSum39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0 || target < 0) return res;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(0,list,candidates,target);
        return res;
    }
    public void dfs(int start,LinkedList<Integer> list,int[] candidates,int target){
        if(target < 0){
            return;
        }
        if(target == 0){
            // 由于对象为引用传递，进行拷贝返回
            res.add(new ArrayList<>(list));
        }else{
            for(int i = start;i < candidates.length;i++){
                if (candidates[i] > target){
                    continue;
                }
                list.add(candidates[i]);
                dfs(i,list,candidates,target-candidates[i]);
                list.removeLast();
            }
        }
    }
}
