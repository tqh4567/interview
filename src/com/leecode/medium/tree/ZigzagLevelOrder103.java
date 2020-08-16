package com.leecode.medium.tree;

import com.utils.TreeNode;
import com.utils.TreeNodeUtils;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class ZigzagLevelOrder103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        int cur = 1,next = 0;
        queue.add(temp);
        List<Integer> list = new ArrayList<>();
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
                if (res.size() % 2 == 1){
                    reverse(list);
                }
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }

    private static void reverse(List<Integer> list) {
        int i = 0,j = list.size()-1;
        while (i < j){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNodeUtils.initTreeNode()));
    }
}
