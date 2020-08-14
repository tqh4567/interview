package com.leecode.easy;

import com.utils.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        dfs(root,"",paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null){
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null){
                paths.add(path);
            }else {
                path += "->";
                dfs(root.left,path,paths);
                dfs(root.right,path,paths);
            }
        }
    }
}
