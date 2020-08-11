package com.leecode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 */
public class Permutation08_07 {

    /**
     * 在寻找不重复的排列时，需要将数组进行排序
     */
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = S.toCharArray();
        dfs(chars,list,builder);
        String[] res = new String[list.size()];
        for (int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(char[] s,List<String> list,StringBuilder builder) {
        if (builder.length() == s.length){
            list.add(builder.toString());
            return;
        }
        for (char c : s) {
            if (builder.toString().contains(String.valueOf(c))) {
                continue;
            }
            builder.append(c);
            dfs(s, list, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation08_07 permutation = new Permutation08_07();
        System.out.println(Arrays.toString(permutation.permutation("qwe")));
    }
}
