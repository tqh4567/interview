package com.offer;

public class LengthOfLongestSubstring48 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;
        int max = 0;
        int n = s.length();
        boolean[] flag = new boolean[128];
        while (right < n){
            if (flag[s.charAt(right)]){
                max = Math.max(max,right-left);
                while (left < right && s.charAt(left) != s.charAt(right)){
                    flag[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }else {
                flag[s.charAt(right)] = true;
                right++;
            }
        }
        return Math.max(max,right-left);
    }

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring(\"abcda\") = " + lengthOfLongestSubstring("abcbcbc"));
    }
}
