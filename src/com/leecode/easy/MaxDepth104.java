package com.leecode.easy;

import com.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int level = 0;
        int cur =1,next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.remove();
            cur -- ;
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
                level ++;
            }
        }
        return level;
    }
}
