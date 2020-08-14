package com.leecode.easy;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 */
public class IsIsomorphic205 {
    /* 有一个用例过不了
    public boolean isIsomorphic(String s, String t) {
        return help(s,t) && help(t,s);
    }
    public boolean help(String s, String t) {
        if (s.length() != t.length()) return false;
        int  i = 0,j = 0;
        while (i < s.length()-1 && j < t.length()-1){
            int countj = 1,countk = 1;
            while (i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                countj ++;
                i++;
            }
            while (j < t.length()-1 && t.charAt(j) == t.charAt(j+1)){
                countk ++;
                j++;
            }
            if (countj != countk){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic205 isIsomorphic = new IsIsomorphic205();
        System.out.println(isIsomorphic.isIsomorphic("foo", "aad"));
    }

     */
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = i + 1;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }
}
