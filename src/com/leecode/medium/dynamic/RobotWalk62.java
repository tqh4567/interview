package com.leecode.medium.dynamic;

public class RobotWalk62 {
    public static int uniquePaths(int m, int n) {

        int[][] f = new int[m][n];
        for (int k = 0;k < m;k++){
            f[k][0] = 1;
        }
        for (int l = 0;l < n;l++){
            f[0][l] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println("uniquePaths(1,1) = " + uniquePaths(3,2 ));
    }
}
