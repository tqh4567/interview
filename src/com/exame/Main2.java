package com.exame;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = {9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
        String s = "hello";
        String str = "oo";
        System.out.println("strStr(s,str) = " + strStr(s, str));
        String[] ss = {"ab","a"};
        System.out.println("longestCommonPrefix(ss) = " + longestCommonPrefix(ss));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) return "";
        int n = strs.length;
        if(n == 1) return strs[0];
        String s = strs[0];
        int m = s.length();
        for(int i = 0; i < m;i++){
            for(int j = 1; j < n;j++){
                if(strs[j].charAt(i) != s.charAt(i)){
                    return s.substring(0,i);
                }
            }
        }
        return s;
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int arr = (digits[n-1]+1)/10; //进位
        digits[n-1] = (digits[n-1]+1)%10;
        for(int i = n-2;i >= 0;i--){
            int cur = (digits[i] + arr)%10;
            arr = (digits[i] + arr)/10;
            digits[i] = cur;
        }
        if(arr == 1){
            int[] res = new int[n+1];
            res[0] = 1;
            for(int i = 1;i <= n;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;

    }
    public static int strStr(String haystack, String needle) {
        if(haystack == null) return -1;
        if(!haystack.contains(needle)) return -1;
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0;i < n;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(i+m < n && needle.equals(haystack.substring(i,i+m))){
                    return i;
                }
            }
        }
        return -1;
    }

}
