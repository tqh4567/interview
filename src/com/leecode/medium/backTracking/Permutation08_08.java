package com.leecode.medium.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 */
public class Permutation08_08 {

    /**
     * 在寻找不重复的排列时，需要将数组进行排序
     */
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        boolean[] visited = new boolean[S.length()];
        StringBuilder builder = new StringBuilder();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        dfs(chars,visited,list,0,builder);
        String[] res = new String[list.size()];
        for (int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(char[] s, boolean[] visited, List<String> list, int begin, StringBuilder builder) {
        if (builder.length() == s.length){
            list.add(builder.toString());
            return;
        }
        for (int i = 0;i<s.length;i++){
            if (!visited[i]){
                if (i > 0 && s[i] == s[i-1] && !visited[i-1]){
                    continue;
                }
                visited[i] = true;
                builder.append(s[i]);
                dfs(s,visited,list,i+1,builder);
                visited[i] = false;
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation08_08 permutation = new Permutation08_08();
        System.out.println(Arrays.toString(permutation.permutation("ab")));
    }
}
