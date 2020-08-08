package com.leecode.medium;


import com.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
