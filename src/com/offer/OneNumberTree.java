package com.offer;

public class OneNumberTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode left_right = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(1);
        root.left = left;
        left.left = left1;
        left.right = left_right;
        root.right = right1;
        right1.right =right2;
        System.out.println("isUnivalTree(root) = " + isUnivalTree(root));
    }
    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if(root.left != null && root.right != null){
            if(root.val == root.left.val && root.left.val == root.right.val){
               return isUnivalTree(root.left)&&isUnivalTree(root.right);
            }
        }else if(root.left == null && root.right == null){
            return true;
        }else if(root.left != null && root.right == null){
            if(root.left.val == root.val){
               return isUnivalTree(root.left);
            }
        }else{
            if(root.right.val == root.val){
               return isUnivalTree(root.right);
            }
        }
        return false;
    }
}

