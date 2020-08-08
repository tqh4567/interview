package com.leecode.medium;

import com.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
