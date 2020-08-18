package com.leecode.medium.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */
public class Partition131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        LinkedList<String> list = new LinkedList<>();
        backTrack(s,res,list,0,len);
        return res;
    }

    private void backTrack(String s, List<List<String>> res, LinkedList<String> list, int start, int len) {
        if (start == len){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i < len;i++){
            if (! isPalindrom(s,start,i)){
                continue;
            }
            list.add(s.substring(start,i+1));
            backTrack(s,res,list,i+1,len);
            list.removeLast();
        }
    }

    private boolean isPalindrom(String s, int start, int i) {
        while (start < i){
            if (s.charAt(start) != s.charAt(i)){
                return false;
            }
            start++;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition131 partition = new Partition131();
        System.out.println("partition(\"aabbcd\") = " + partition.partition("ababababababababababababcbabababababababababababa"));
    }
}
