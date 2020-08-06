package com.leecode.middle;

import com.utils.TreeNode;

import java.util.HashMap;

public class Rob337 {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return helper(root,memo);

    }
    public int helper(TreeNode root,HashMap<TreeNode, Integer> memo){
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int max = root.val;
        if(root.left != null) max += (helper(root.left.left,memo)+helper(root.left.right,memo));
        if(root.right != null) max += (helper(root.right.left,memo)+helper(root.right.right,memo));
        int result = Math.max(max,helper(root.left,memo)+helper(root.right,memo));
        memo.put(root,result);
        return result;
    }
}
