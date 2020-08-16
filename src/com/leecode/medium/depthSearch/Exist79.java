package com.leecode.medium.depthSearch;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 */
public class Exist79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        /*菜鸡做法80% 左右的用例
        List<List<Character>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0;i < m;i++){
            LinkedList<Character> list = new LinkedList<>();
            for (int j = 0;j < n;j++){
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, i, j, visited, list, res, word,count);
                }
            }
        }
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(i, j, 0, word, visited, board)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, int idx, String word, boolean[][] visited, char[][] board) {
        if (idx == word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(idx) || visited[i][j])
            return false;
        visited[i][j] = true;
        if (backtrack(i + 1, j, idx + 1, word, visited, board)
                || backtrack(i - 1, j, idx + 1, word, visited, board)
                || backtrack(i, j + 1, idx + 1, word, visited, board)
                || backtrack(i, j - 1, idx + 1, word, visited, board))
            return true;
        visited[i][j] = false; // 回溯
        return false;
    }

    private boolean dfs(char[][] board, int row, int cow, boolean[][] visited, LinkedList<Character> list, List<List<Character>> res, String word, int count) {
        if (row < 0 || row >= board.length || cow <0 || cow >= board[0].length){
            return false;
        }
        if (visited[row][cow]){
            return false;
        }
        if (count < word.length() && board[row][cow] != word.charAt(count)){
            return false;
        }
        if (count == word.length()){
            return true;
        }
        visited[row][cow] = true;
        if(
        dfs(board,row-1,cow,visited,list,res,word, count+1)||
        dfs(board,row+1,cow,visited,list,res,word, count+1)||
        dfs(board,row,cow-1,visited,list,res,word, count+1)||
        dfs(board,row,cow+1,visited,list,res,word, count+1)){
            return true;
        }
        visited[row][cow] = false;
        return false;
    }

    public static void main(String[] args) {
        Exist79 exist = new Exist79();
//        char[][] board  = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board  = {{'A'}};
        System.out.println(exist.exist(board, "A"));
    }
}
