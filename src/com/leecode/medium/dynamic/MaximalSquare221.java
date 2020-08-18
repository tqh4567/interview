package com.leecode.medium.dynamic;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
public class MaximalSquare221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        System.out.println("maximalSquare(matrix) = " + maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0 || matrix[0].length ==0) return max;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0; j < n;j++){
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                    }
                    max = Math.max(dp[i][j],max);
                }

            }
        }
        return max * max;
    }
}
