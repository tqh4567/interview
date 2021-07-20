package com.leecode.easy;

import com.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 */
public class AverageOfLevels637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        int cur = 1;
        int next = 0;
        while (! queue.isEmpty()){
            temp = queue.remove();
            list.add(temp.val);
            cur -- ;
            if (temp.left != null){
                queue.add(temp.left);
                next++;
            }
            if (temp.right != null){
                queue.add(temp.right);
                next ++;
            }
            if (cur == 0){
                res.add(getAvgOfList(list));
                cur = next;
                next = 0;
                list = new ArrayList<>();
            }
        }

        return res;
    }
    public double getAvgOfList(List<Integer> list){
        if (list.size() < 1) return 0d;
        long sum = 0;
        for (int e : list){
            sum += e;
        }
        return sum*1.0/list.size();

    }
}
