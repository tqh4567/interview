package com.leecode.medium.depthSearch;

public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int cow = grid[0].length;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < cow;j++){
                int a =dfs(grid,i,j);
                res = Math.max(res,a);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int cow) {
        if (!inArea(grid,row,cow)){
            return 0;
        }
        if (grid[row][cow] != 1){
            return 0;
        }
        grid[row][cow] = '2';
        return 1 + dfs(grid, row-1, cow) + dfs(grid, row+1, cow) + dfs(grid, row, cow-1) + dfs(grid, row, cow+1);
    }
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland695 maxAreaOfIsland = new MaxAreaOfIsland695();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println("maxAreaOfIsland.maxAreaOfIsland(grid) = " + maxAreaOfIsland.maxAreaOfIsland(grid));
    }
}
