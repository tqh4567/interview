package com.leecode.medium.tree;

import com.utils.TreeNode;
import com.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrder102 {
    // 按层输出二叉树
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode temp = root;
        int cur = 1;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.remove();
            list.add(temp.val);
            cur --;
            if (temp.left != null){
                queue.add(temp.left);
                next ++;
            }
            if (temp.right != null){
                queue.add(temp.right);
                next ++;
            }
            if (cur == 0){
                cur = next;
                next = 0;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("levelOrder(TreeNodeUtils.initTreeNode()) = " + levelOrder(TreeNodeUtils.initTreeNode()));
    }
}
