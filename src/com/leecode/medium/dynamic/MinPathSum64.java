package com.leecode.medium.dynamic;

public class MinPathSum64 {
    /**
     * 最短路径和
     * @param grid 路径信息二位数组
     * @return 最短路径
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] min = new int[m][n];
        int sum1 = 0;
        for (int i = 0 ;i < m;i++){
            sum1 += grid[i][0];
            min[i][0] = sum1;
        }
        int sum2 = 0;
        for (int i = 0 ;i < n;i++){
            sum2 += grid[0][i];
            min[0][i] = sum2;
        }
        for (int i = 1;i < m;i++){
            for (int j = 1; j < n;j++){
                min[i][j] = Math.min(min[i-1][j],min[i][j-1]) + grid[i][j];
            }
        }
        return min[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("minPathSum(grid) = " + minPathSum(grid));
    }
}
