package com.newcode.leetcode;

import com.utils.TreeNode;
import com.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 求二叉树的最小深度，就是根节点到叶子节点的最小距离
 */
public class MindeepForTree {
    public static void main(String[] args) {
        MindeepForTree tree = new MindeepForTree();
        System.out.println("tree.getTreeMindeep(TreeNodeUtils.initTreeNode()) = " + tree.getTreeMindeep(TreeNodeUtils.initTreeNode()));
    }
    // 递归可通过
    public int getTreeMindeep(TreeNode root) {
        if(root == null) return 0;
        int left = getTreeMindeep(root.left);
        int right = getTreeMindeep(root.right);

        if(left==0 || right==0)
            return left+right+1;
        else return Math.min(left,right)+1;
    }
        /* 能通过75%
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        int cur = 1,next = 0;
        while (! queue.isEmpty()){
            temp = queue.remove();
            list.add(temp.val);
            cur--;
            if (temp.left != null){
                queue.add(temp.left);
                next++;
            }
            if (temp.right != null){
                queue.add(temp.right);
                next++;
            }
            if (cur == 0){
                res.add(list);
                cur = next;
                next = 0;
                list = new ArrayList<>();
            }
        }
        for (int i = 0;i < res.size();i++){
            if (res.get(i).size() != myPow(2,i)){
                return i;
            }
        }
        return res.size();
    }
    public int myPow(int m,int n){
        int res = 1;
        for (int i = 0;i < n;i++){
            res *= m;
        }
        return res;
    }

         */
}
