package com.leecode.medium;

public class uniquePathsWithObstacles63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 1 && n == 1) return 1;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 1;i < m;i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }
        for(int i = 1;i < n;i++){
            if(obstacleGrid[0][1] == 1){
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] =dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
         **/
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0},{1,1},{0,0}};
        System.out.println("uniquePathsWithObstacles(grid) = " + uniquePathsWithObstacles(grid));
    }
}
