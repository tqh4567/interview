package com.newcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ByteDance2019 {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0;i < n;i ++){
            String s = sc.next();

        }
        */
        int[] nums = {1 ,1 ,1 ,1 ,2, 2, 3, 3 ,5 ,6 ,7 ,8, 9};
        canWin(nums);

    }
    public static String get(String str){
        for (int i = 0; i < str.length() - 2; i++) {
            char num_1 = str.charAt(i);
            char num_2 = str.charAt(i + 1);
            char num_3 = str.charAt(i + 2);
            if (num_1 == num_2) {
                if (num_3 == num_2) {
                    str = str.substring(0, i + 1) + str.substring(i + 2);
                    i = i - 1;
                } else if (i + 3 < str.length()) {
                    char num_4 = str.charAt(i + 3);
                    if (num_3 == num_4) {
                        str = str.substring(0, i + 2) + str.substring(i + 3);
                        i = i - 1;
                    }
                }
            }
        }
        return str;
    }
    public static int getPlanNumbers(int[] points,int length){
        int n = points.length;
        Arrays.sort(points);
        int count = 0;
        for (int i = 1;i < n;i++) {
            int j = 0,k = n-1;
            while (points[i]-points[j] > length){
                j++;
            }
            while (points[k] - points[i] > length){
                k--;
            }
            count = count + (i-j)*(k-i);
        }
        return count;
    }
    public static void canWin(int[] points){
        int count = 0;
        for (int m = 1;m <= 9;m++) {
            int[] f = new int[10];
            for (int point : points){
                f[point] ++;
            }
            if(method(points,f,m)){
                count = count + 1;
                System.out.print(m+" ");
            }
        }
        if (count == 0){
            System.out.print(0);
        }
    }
    public static boolean method(int[] points,int[] f,int m){
        f[m] = f[m]+1;
        int count2 = 0;
        for (int i = 1; i <= 9; i++) {
            if (f[i] == 2) {
                f[i] = 0;
                count2 = count2 + 1;
            }
        }
        if (count2 != 1) return false;
        for (int i = 1; i <= 9; i++) {
            if (f[i] >= 3) {
                if (f[i] > 4){
                    return false;
                }else {
                    f[i] = f[i] - 3;
                }
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (f[i] == 2) {
                f[i] = f[i] - 2;
            }
        }
        for (int i = 0; i < 8; i++) {
            int j = i;
            while (f[j] == 1 && f[j + 1] == 1) {
                j++;
            }
            if ((j - i)%3 == 2){
                while (i <= j){
                    points[i] = 0;
                    i++;
                }
            }
        }
        for (int i = 1;i<= 9;i++){
            if (f[i] != 0){
                return false;
            }
        }
        return true;
    }
}
