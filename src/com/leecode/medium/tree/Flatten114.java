package com.leecode.medium.tree;

import com.utils.TreeNode;

/**
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class Flatten114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.right != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            root.right.right = temp;
        }else if (root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
        }
        else if (root.left == null && root.right != null){
            return;
        }else {
            return;
        }
        flatten(root.left);
        flatten(root.right);
    }
}
