package com.leecode.easy;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 */
public class IslandPerimeter463 {
    // dfs做法
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int cow = grid[0].length;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < cow;j++){
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int cow) {
        if (!isInArea(grid,row,cow)){
            return 1;
        }
        if (grid[row][cow] == 0){
            return 1;
        }
        if (grid[row][cow] != 1){
            return 0;
        }
        grid[row][cow] = 2;
        return dfs(grid,row-1,cow)+dfs(grid,row+1,cow)+dfs(grid,row,cow-1)+dfs(grid,row,cow+1);
    }
    public boolean isInArea(int[][] grid, int row, int cow){
        return row >=0 && row < grid.length && cow >= 0 && cow < grid[0].length;
    }
    public int islandPerimeter2(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int lines = 4;
                    //判断这个岛旁边连接了多少个岛
                    if(i > 0 && grid[i - 1][j] == 1) lines--;
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) lines--;
                    if(j > 0 && grid[i][j - 1] == 1) lines--;
                    if(j < grid[0].length - 1 && grid[i][j + 1] == 1) lines--;
                    sum += lines;
                }
            }
        }
        return sum;
    }
}
