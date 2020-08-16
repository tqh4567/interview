package com.leecode.medium.tree;

import com.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 */
public class IsValidBST98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode temp = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty() || temp != null){
            while (temp != null){
                deque.push(temp);
                temp = temp.left;
            }
            temp = deque.pop();
            list.add(temp.val);
            if (temp.right != null){
                temp = temp.right;
            }else {
                temp = null;
            }
        }
        for (int i = 1; i < list.size();i++){
            if(list.get(i) < list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
