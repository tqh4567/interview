package com.offer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            list.add(in.nextInt());
        }
        list.add(10);
        list.add(9);
        list.add(2);
        list.add(5);
        list.add(3);
//        list.add(7);
//        list.add(108);
//        list.add(18);

        int n = list.size();
        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i++){
            dp[i][i] = 1;
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < i;j++){
                if(list.get(j)>list.get(j+1)){
                    dp[i][j+1] = dp[i][j];
                }else if(list.get(j)<list.get(j+1)){
                    dp[i][j+1] = Math.max(dp[i][j],dp[i][j+1])+1;
                }
            }
        }
        System.out.println(dp[n-1][n-1]+1);
    }
}