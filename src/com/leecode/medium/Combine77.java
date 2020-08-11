package com.leecode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(n,list,k,1);
        return res;
    }
    public void dfs(int n, LinkedList<Integer> list, int k,int begin) {
        // 已经走到底了，将结果加入结果集返回
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin;i <= n ;i++) {
            list.add(i);
            // 继续访问下一层
            dfs(n,list, k,i+1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine77 combine = new Combine77();
        System.out.println("combine.combine(4,2) = " + combine.combine(4, 2));
    }
}
