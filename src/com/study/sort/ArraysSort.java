package com.study.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 集合排序练习
 */
public class ArraysSort {
    public static void main(String[] args) {
//        int[][] arrays = {{1,1},{3,4},{1,7},{8,1},{2,6},{3,1}};
//        int[][] arrays = {{4,34},{3,35}};
//        int[][] arrays = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[][] arrays = {{1,0},{0,0},{1,0}};
        System.out.println("sortArray(arrays) = " + Arrays.toString(kWeakestRows(arrays, 2)));
    }
    public static int[][] sortArray(int[][] arrays){
        Arrays.sort(arrays, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }else {
                return o2[0] - o1[0];
            }
        });
        return arrays;
    }
    public static int[][] sortArray1(int[][] arrays){
        Arrays.sort(arrays, (o1, o2) -> {
            return o2[0]-o1[0];
        });
        return arrays;
    }
    public static int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length,n = mat[0].length;
        int[][] arrs = new int[m][2];
        for(int i = 0;i < m;i++){
            int count = 0;
            for(int j = 0 ;j < n ;j++){
                if(mat[i][j] == 1){
                    count++;
                }else {
                    break;
                }
            }
            arrs[i] = new int[]{i,count};
        }
        Arrays.sort(arrs,(o1,o2)->{
            if(o2[1] == o1[1]){
                return o1[0]-o2[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        int[] ans = new int[k];
        for(int i = 0;i < k;i++){
            ans[i] = arrs[i][0];
        }
        return ans;
    }
}
