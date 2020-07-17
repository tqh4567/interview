package com.leecode.hard;

/**
 * 最短编辑距离
 */
public class MinDistance72 {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m+1][n+1];
        // word1为空字符串，插入操作
        for (int i = 1;i <= n;i++){
            f[0][i] = f[0][i-1] +1;
        }
        // word2为空字符串，删除操作
        for (int i = 1;i <= m;i++){
            f[i][0] = f[i-1][0] +1;
        }
        for (int i = 1;i <= m;i++){
            for (int j = 1;j <= n;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1];
                }else {
                    f[i][j] = Math.min(Math.min(f[i-1][j-1],f[i-1][j]),f[i][j-1]) + 1;
                }
            }
        }
        return f[m][n];

    }

    public static void main(String[] args) {
        System.out.println("minDistance = " + minDistance("ab", "ac"));
    }

}
