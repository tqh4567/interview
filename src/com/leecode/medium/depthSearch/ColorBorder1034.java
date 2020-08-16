package com.leecode.medium.depthSearch;

public class ColorBorder1034 {
    boolean[][] visited;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int row = grid.length;
        int cow = grid[0].length;
        visited = new boolean[row][cow];
        int oldClor = grid[r0][c0];
        dfs(grid,r0,c0,oldClor,color);

        /*
        // 将改错的节点再改回来，以下判断可能会存在问题比如[[1,2,2],[2,3,2]] 0，1，3
        for (int i = 1;i < cow-1;i++){
            for (int j = 1; j < row-1;j++){
                // 上下左右全为新的颜色，将中间节点恢复
                if (grid[i][j] == color && grid[i-1][j] == color && grid[i+1][j] == color && grid[i][j-1] == color && grid[i][j+1] == color){
                    grid[i][j] = oldClor;
                }
                // 只有一个节点为新的颜色，将节点恢复
                if (grid[i][j] == color && grid[i-1][j] != color && grid[i+1][j] != color && grid[i][j-1] != color && grid[i][j+1] != color){
                    grid[i][j] = oldClor;
                }
            }
        }
        // 矩形边界上的判断
        for (int i = 0;i < cow-1;i++){
            if (i == 0){
                if (grid[0][i] == color && grid[0][i+1] != color && grid[1][i] != color){
                    grid[0][i] = oldClor;
                }
                if (grid[row-1][i] == color && grid[row-1][i+1] != color && grid[row-2][i] != color){
                    grid[row-1][i] = oldClor;
                }
            }else if (i == cow-1){
                if (grid[0][i] == color && grid[0][i-1] != color && grid[1][i] != color){
                    grid[0][i] = oldClor;
                }
                if (grid[row-1][i] == color && grid[row-1][i-1] != color && grid[row-2][i] != color){
                    grid[row-1][i] = oldClor;
                }
            }else {
                if (grid[0][i] == color && grid[0][i + 1] != color && grid[0][i - 1] != color && grid[1][i] != color ) {
                    grid[0][i] = oldClor;
                }
                if (grid[row-1][i] == color && grid[row-1][i + 1] != color && grid[row-1][i - 1] != color && grid[row-2][i] != color ) {
                    grid[row-1][i] = oldClor;
                }
            }
        }
        for (int i = 1;i < row - 1;i++){
            if (grid[i][0] == color && grid[i-1][0] != color && grid[i+1][0] != color && grid[i][1] != color ) {
                grid[i][0] = oldClor;
            }
            if (grid[i][cow-1] == color && grid[i-1][cow-1] != color && grid[i+1][cow-1] != color && grid[i][cow-2] != color ) {
                grid[i][cow-1] = oldClor;
            }
        }
         */

        return grid;
    }

    private void dfs(int[][] grid, int row, int cow, int oldClor, int color) {
        if (row < 0 || row >= grid.length || cow <0 || cow >= grid[0].length){
            return;
        }
        if (visited[row][cow] || grid[row][cow] != oldClor){
            return;
        }
        if (row == 0 || cow == 0 || row == grid.length-1 || cow == grid[0].length-1){
            grid[row][cow] = color;
        }else {
            if( row >=1 && grid[row-1][cow] != oldClor && !visited[row - 1][cow])
            { grid[row][cow] = color; }
            if( cow>=1 && grid[row][cow-1] != oldClor && !visited[row][cow - 1])
            { grid[row][cow] = color; }
            if( row<grid.length - 1 && grid[row+1][cow]!= oldClor && !visited[row + 1][cow])
            { grid[row][cow] = color; }
            if( cow<grid[0].length - 1 && grid[row][cow+1] != oldClor && !visited[row][cow + 1])
            { grid[row][cow] = color; }
        }
        visited[row][cow] = true;

        dfs(grid, row-1, cow, oldClor,color);
        dfs(grid, row+1, cow, oldClor,color);
        dfs(grid, row, cow-1, oldClor,color);
        dfs(grid, row, cow+1, oldClor,color);
    }

    public static void main(String[] args) {
        ColorBorder1034 colorBorder = new ColorBorder1034();
        int[][] grid = {{1,2,2},{2,3,2}};
        colorBorder.colorBorder(grid,0,1,3);
    }
}
