package com.leecode.middle;

public class LongestPalindrome05 {
    // 性能最差 （找到所有的回文子串，比较长短，拿出最长的那个字串）
    /**
    public String longestPalindrome(String s) {
        if(s.length() <=1) return s;
        int begin = 0,n = s.length();
        int max = 1;
        for(int i = 0 ;i < n-1;i++){
            for(int j = i + 1;j<n;j++){
                if (j - i + 1 > max && isPalindrome(s, i, j)) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
    public boolean isPalindrome(String s,int i ,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }**/

    // 动态规划
    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 如果子字符串长度小于3，此时只需要判断头尾即可
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    public static void main(String[] args) {
        LongestPalindrome05 longestPalindrome05 = new LongestPalindrome05();
        System.out.println("longestPalindrome05.longestPalindrome(\"cbbd\") = " + longestPalindrome05.longestPalindrome("cbbd"));
    }
}
