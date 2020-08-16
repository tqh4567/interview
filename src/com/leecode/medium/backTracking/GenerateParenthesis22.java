package com.leecode.medium.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class GenerateParenthesis22 {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n < 1) return new ArrayList<>();
        dfs(n,n,"");
        return list;

    }
    public void dfs(int m,int n,String str){
        // 左括号用的比右括号要少，例如n = 3,())此时m = 2,n = 1
        if (m > n){
            return;
        }
        if (m==0 && n == 0){
            list.add(str);
            return;
        }
        if (m > 0){
            dfs(m-1,n,str+"(");
        }
        if (n > m){
            dfs(m,n-1,str+")");
        }

    }
}
