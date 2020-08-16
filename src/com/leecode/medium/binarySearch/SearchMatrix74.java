package com.leecode.medium.binarySearch;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 通过次数56,831提交次数147,063
 *
 */
public class SearchMatrix74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0,j = n-1;
        while (i < m && j >= 0){
            if (matrix[i][j] < target){
                i ++;
            }else if (matrix[i][j] > target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println("searchMatrix(matrix,3) = " + searchMatrix(matrix, 31));
    }
}
