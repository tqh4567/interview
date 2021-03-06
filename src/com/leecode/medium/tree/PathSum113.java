package com.leecode.medium.tree;

import com.utils.TreeNode;
import com.utils.TreeNodeUtils;

import java.util.*;

public class PathSum113 {
    // 寻找所有路径指定为sum的路径，只能通过90%用例，太菜鸡了
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode temp = root;
        List<List<Integer>> res = new ArrayList<>();
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty() || temp != null){

            while (temp != null){
                list.add(temp.val);
                num += temp.val;
                deque.push(temp);
                temp = temp.left;
            }
            temp = deque.pop();
            if (temp == root){
                num = temp.val;
                list = new ArrayList<>();
                list.add(temp.val);
            }
            if (temp.right != null) {
                temp = temp.right;
            }else {
                List<Integer> tempList = new ArrayList<>(list);
                if (num == sum && (temp.right == null && temp.left == null)) {
                    res.add(tempList);
                }
                num -= temp.val;
//                list = list.subList(0, list.size() - 1);
                list.remove(list.size()-1);
                temp = null;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.initTreeNode();
        PathSum113 pathSum = new PathSum113();
        System.out.println(pathSum.pathSum3(root, 9));
    }
    public static TreeNode getTreeNode(){
        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
        root.left = new TreeNode(-2);
        return root;
    }
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            ans.add(arr);
            return ans;
        }
        List<List<Integer>> left = pathSum2(root.left,sum - root.val);
        List<List<Integer>> right = pathSum2(root.right,sum - root.val);
        for(List<Integer> list : left){
            list.add(0,root.val);
            ans.add(list);
        }
        for(List<Integer> list : right){
            list.add(0,root.val);
            ans.add(list);
        }
        return ans;
    }
    // 回溯算法
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root,list,sum,res);
        return res;
    }

    private void dfs(TreeNode root, LinkedList<Integer> list, int sum, List<List<Integer>> res) {
        if (root == null) return;
        list.add(root.val);
        if (root.val == sum && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }else {
            dfs(root.left,list,sum-root.val,res);
            dfs(root.right,list,sum-root.val,res);
        }
        list.removeLast();

    }
}
