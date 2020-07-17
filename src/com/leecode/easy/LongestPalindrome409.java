package com.leecode.easy;


import java.util.Arrays;

public class LongestPalindrome409 {

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int equalCount = 0;
        int notEqualCount = 0;
        for (int i = 1;i < chars.length;i++){
            if (chars[i] == chars[i-1]){
                equalCount ++;
            }else {
                notEqualCount ++;
            }
        }
        return notEqualCount >= (equalCount+1)/2 ? equalCount+1 : equalCount+2;
    }

    public static void main(String[] args) {
        System.out.println("longestPalindrome = " + longestPalindrome("ac"));
    }
}
