package com.leecode.medium.array;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
public class GenerateMatrix59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = 1;
        int top = 0,bottle = n-1;
        int left = 0,right = n-1;
        while (top <= bottle && left <= right){
            for (int i = left;i <= right;i++){
                matrix[top][i] = k++;
            }
            for (int i = top+1;i <= bottle;i++){
                matrix[i][right] = k++;
            }
            if (left < right && top < bottle){
                for (int i = right - 1;i>left;i--){
                    matrix[bottle][i] = k++;
                }
                for (int i = bottle ;i > top;i--){
                    matrix[i][left] = k++;
                }
            }
            left ++;
            right --;
            top ++;
            bottle --;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println("generateMatrix(3) = " + Arrays.deepToString(generateMatrix(3)));
    }
}
