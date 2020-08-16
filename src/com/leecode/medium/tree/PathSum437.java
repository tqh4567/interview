package com.leecode.medium.tree;

import com.utils.TreeNode;
import com.utils.TreeNodeUtils;

public class PathSum437 {
    /*90%
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root,list,sum,res);

        return res.size()+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private void dfs(TreeNode root, LinkedList<Integer> list, int sum, List<List<Integer>> res) {
        if (root == null) return ;
        list.add(root.val);
        if (sum == root.val){
            res.add(new ArrayList<>(list));
        }else {
            dfs(root.left, list,sum-root.val,res);
            dfs(root.right, list,sum-root.val,res);
        }
        list.removeLast();
    }
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
        {
            return 0;
        }
        return dfs(root,sum) + pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (sum == root.val){
            res += 1;
        }
        res += dfs(root.left,sum-root.val);
        res += dfs(root.right,sum-root.val);

        return res;
    }
    public static void main(String[] args) {
        PathSum437 pathSum = new PathSum437();
        TreeNode root = TreeNodeUtils.initTreeNode();
        System.out.println("pathSum.pathSum(root,5) = " + pathSum.pathSum(root, 6));
    }
}
