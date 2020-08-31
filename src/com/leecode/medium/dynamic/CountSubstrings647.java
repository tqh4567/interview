package com.leecode.medium.dynamic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 */

/**
 * 这是道传统的动态规划题目，采用回溯法可以得到具体分割的情况，但是却不能去重
 */
public class CountSubstrings647 {
    public int countSubstrings2(String s) {
        // 动态规划
        if(s == null || s.equals("")){
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = s.length();
        for(int i = 0; i<n; i++) dp[i][i] = true;
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    result++;
                }
            }
        }
        return result;
    }
    public int countSubstrings(String s) {
        // 暴力解法
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int n = s.length();
        int count = 0;
        for (int i = 0;i < n;i++){
            for (int j = i;j < n;j++){
                if (isParal(s,i,j)){
                    count ++;
                }
            }
        }
        return count;
    }
    /* 回溯算法
    public int countSubstrings(String s) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String>  list = new LinkedList<>();
        int n = s.length();
        if (s.length() == 0) return 0;
        backTrack(res,list,s,0,n);
        return res.size();
    }

    private void backTrack(List<List<String>> res, LinkedList<String> list, String s, int start, int n) {
        if (start == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i < n;i++){
            if (!isParal(s,start,i)){
                continue;
            }
            list.add(s.substring(start,i+1));
            backTrack(res, list, s, i+1, n);
            list.removeLast();
        }
    }
    */

    private boolean isParal(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        CountSubstrings647 count = new CountSubstrings647();
        System.out.println("count.countSubstrings(\"aaa\") = " + count.countSubstrings("aaaa"));
    }
}
