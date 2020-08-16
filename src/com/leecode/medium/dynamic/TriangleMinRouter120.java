package com.leecode.medium.dynamic;

import java.util.ArrayList;
import java.util.List;

public class TriangleMinRouter120 {
    /**
     * 查找三角形中的最短路径
     * @param triangle 列表
     * 只适用全为正数的情况
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) return 0;
        int sum  = triangle.get(0).get(0);
        int index = 0;
        for (int i = 0;i < triangle.size()-1;i ++){
            int min = Math.min(triangle.get(i+1).get(index), triangle.get(i+1).get(index + 1));
            index = triangle.get(i+1).get(index) > triangle.get(i+1).get(index + 1) ? index + 1 : index;
            sum += min;
        }
        return sum;
    }

    /**
     * 动态规划时间复杂度和空间复杂度均为n2
     * @param triangle
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() < 1) return 0;
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1;i < n;++ i){
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for (int j = 1;j < i;++j){
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i-1][i-1] +triangle.get(i).get(i);
        }
        int min = f[n-1][0];
        for (int i = 1;i<n;++i){
            min = Math.min(min,f[n-1][i]);
        }
        return min;


    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(-1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(-1);
        l3.add(-3);
//        List<Integer> l4 = new ArrayList<>();
//        l4.add(4);
//        l4.add(1);
//        l4.add(8);
//        l4.add(3);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
//        triangle.add(l4);
        System.out.println("minimumTotal(triangle) = " + minimumTotal2(triangle));
    }
}
