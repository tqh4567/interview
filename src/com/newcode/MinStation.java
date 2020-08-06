package com.newcode;

import java.util.Arrays;

public class MinStation {
    public static int work (int n, int[] a) {
        int count = 1;
        for(int i = 1;i < a.length;i++){
            int num = a[i]-a[i-1];
            if(!isSampleNumber(num)){
                if (count % 2 == 0) {
                    count = count + 2;
                } else{
                    if(isSampleNumber(num-2)){
                        count+=2;
                    }else{
                        count+=3;
                    }
                }
            }else {
                count++;
            }
        }
        return count;
    }
    public static boolean isSampleNumber(int n){
        for(int i = 2;i<n/2;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public int selectPresent (int[][] presentVolumn) {
        // write code here
        int m = presentVolumn.length,n = presentVolumn[0].length;
        int[][] dp = new int[m][n];
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i<m;i++){
            sum1 += presentVolumn[i][0];
            presentVolumn[i][0] = sum1;
        }
        for(int j = 0;j<n;j++){
            sum2 += presentVolumn[0][j];
            presentVolumn[0][j] = sum2;
        }
        for(int i = 1;i< m;i++){
            for(int j = 1;j<n;j++){
                presentVolumn[i][j] =
                        Math.min(presentVolumn[i-1][j-1],
                                Math.min(presentVolumn[i-1][j],presentVolumn[i][j-1]))+presentVolumn[i][j];
            }
        }
        return presentVolumn[m-1][n-1];
    }
    public static void main(String[] args) {
        int[] nums ={0,4,10,18,20,22,28,29};
        System.out.println("work(nums,8) = " + work(8, nums));
    }
}
