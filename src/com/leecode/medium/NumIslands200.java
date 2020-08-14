package com.leecode.medium;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class NumIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)return 0;
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0;i < row;++i){
            for (int j = 0;j < col;++j){
                if (grid[i][j] == '1'){
                    ++ res;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '2';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col+1);
    }
    public boolean inArea(char[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0';
    }
}
