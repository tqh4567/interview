package com.leecode.medium.tree;

import com.utils.TreeNode;
import com.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 通过次数60,776提交次数94,670
 *
 */
public class RightSideView199 {
    // 借助二叉树的层次遍历进行实现
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode temp = root;
        int cur = 1;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
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
                // 右视图res.add(list.get(list.size()-1));，左视图res.add(list.get(0));
                res.add(list.get(list.size()-1));
                list = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RightSideView199 rightSideView = new RightSideView199();
        System.out.println(rightSideView.rightSideView(TreeNodeUtils.initTreeNode()));
    }
}
