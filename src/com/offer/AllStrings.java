package com.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串全排列情况
 */
public class AllStrings {
    List<String> result = new ArrayList<>();
    char[] chars;
    public  String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }
    public  void dfs(int x){
        if(x == chars.length - 1){
            result.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = x;i < chars.length;i++){
            if (set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }
    public void swap(int c1,int c2){
        char temp = chars[c1];
        chars[c1] = chars[c2];
        chars[c2] = temp;
    }

    public static void main(String[] args) {
        AllStrings allStrings = new AllStrings();
        String[] abcs = allStrings.permutation("abc");
        System.out.println("abcs = " + abcs);
    }
}
