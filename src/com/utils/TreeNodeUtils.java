package com.utils;

public class TreeNodeUtils {
    public static TreeNode initTreeNode() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode right_left = new TreeNode(1);
        TreeNode right_right = new TreeNode(1);
        right.left = right_left;
        right.right = right_right;
        TreeNode left_left = new TreeNode(1);
        TreeNode left_right = new TreeNode(4);
        left.left = left_left;
        left.right = left_right;
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }
}
