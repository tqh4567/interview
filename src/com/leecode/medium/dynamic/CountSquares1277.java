package com.leecode.medium.dynamic;

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *
 */
public class CountSquares1277 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        String s = "abcdefghigklmn";
        System.out.println("s.substring(0,8) = " + s.substring(0,8));
        System.out.println("countSquares(matrix) = " + countSquares(matrix));
    }
    public static int countSquares(int[][] matrix) {
        int count = 0;
        if (matrix.length == 0 || matrix[0].length ==0) return count;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0; j < n;j++){
                if (matrix[i][j] == 1){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                    }
                    count += dp[i][j];
                }

            }
        }
//        for (int[] nums : dp){
//            for (int num : nums){
//                count += num;
//            }
//        }
        return count;

    }
}
