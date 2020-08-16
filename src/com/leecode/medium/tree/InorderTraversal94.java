package com.leecode.medium.tree;


import com.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 *给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 */
public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root;
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(root);
        while (temp != null || !deque.isEmpty()){
            while (temp != null){
                deque.push(temp);
                temp = temp.left;
            }
            temp = deque.pop();
            res.add(temp.val);
            if (temp.right != null){
                deque.push(temp.right);
            }else {
                temp = null;
            }

        }
        return res;
    }
}
