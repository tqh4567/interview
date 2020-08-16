package com.leecode.medium.tree;

import com.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树先序遍历
 */
public class PreorderTraversal144 {
    private List<Integer> result = null;
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return  new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        TreeNode temp = root;
        deque.push(temp);
        while (!deque.isEmpty()){
            temp = deque.pop();
            res.add(temp.val);
            if (temp.right != null){
                deque.push(temp.right);
            }
            if (temp.left != null){
                deque.push(temp.left);
            }
        }
        return res;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
