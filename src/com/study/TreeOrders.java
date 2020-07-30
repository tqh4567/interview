package com.study;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.utils.TreeNode;

import java.util.*;

public class TreeOrders {
    TreeNode treeNode = null;
    //二叉树的节点类型，定义内部类
    public static TreeNode initTreeNode() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode right_left = new TreeNode(4);
//        TreeNode right_right = new TreeNode(9);
        right.left = right_left;
//        right.right = right_right;
//        TreeNode left_left = new TreeNode(1);
//        TreeNode left_right = new TreeNode(3);
//        left.left = left_left;
//        left.right = left_right;
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    public static void main(String[] args) {
        System.out.println("先序遍历");
        for (Integer i : getPreOrder(initTreeNode())){
            System.out.print(i);
        }
        System.out.println("\n");
        System.out.println("中序遍历");
        for (Integer i : getInOrder(initTreeNode())){
            System.out.print(i);
        }
        System.out.println("\n");
        System.out.println("后序遍历");
        for (Integer i : postOrder(initTreeNode())){
            System.out.print(i);
        }
        System.out.println("\n");
        System.out.println("层次遍历");
        for (Integer i : levelOrder(initTreeNode())){
            System.out.print(i);
        }
    }

    /**二叉树先序遍历
     * 1、将根节点入栈，
     * 2、如果栈非空，将栈顶元素出栈，访问栈顶节点node对应的值
     * 3、如果node的右子树不为空，将node的右子树入栈
     * 4、如果node的左子树不为空，将node的左子树入栈
     * 5、重复2-4，直至栈空
     * @param root 树的根节点
     * @return 遍历结果
     */
    public static List<Integer> getPreOrder(TreeNode root){
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pop();
            list.add(node.val);
            if(node.right != null){
                deque.push(node.right);
            }
            if (node.left!=null){
                deque.push(node.left);
            }
        }
        return list;
    }
    /**二叉树中序遍历
     * 1、将根节点入栈，
     * 2、如果栈非空或者根节点不为null，将左子树加入栈，直到左子树为空
     * 3、将栈顶元素node出栈，将节点值加入结果集
     * 4、如果node的右子树不为空，将node的右子树入栈；否者将node置空
     * 5、重复2-4，直至栈空
     * @param root 树的根节点
     * @return 遍历结果
     */
    public static List<Integer> getInOrder(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || temp != null){
            while(temp != null){
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
        return list;
    }

    /**
     * 后续遍历
     * @param root 树
     * @return 结果集
     */
    public static List<Integer> postOrder(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || temp != null){
            while(temp != null){
                deque.push(temp);
                temp = temp.left;
            }
            if (!deque.isEmpty()){
                temp = deque.peek();
                if (temp.right == null || temp.right == pre){
                    temp = deque.pop();
                    list.add(temp.val);
                    pre = temp;
                    temp = null;
                }else {
                    temp = temp.right;
                }
            }

        }
        return list;
    }
    public static List<Integer> levelOrder(TreeNode root){
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }
}
