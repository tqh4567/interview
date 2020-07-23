package com.offer;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring48 {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<1) return 0;
        int left = 0,right = 0;
        int max =0;
        boolean[] flag = new boolean[128];
        while (right<s.length()){
            if(!flag[s.charAt(right)]){
                flag[s.charAt(right)] = true;
                right++;
            }else {
                max = Math.max(right-left,max);
                while(left<right && s.charAt(right)!=s.charAt(left)){
                    flag[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        return Math.max(right-left,max);
    }
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring = " + lengthOfLongestSubstring("abcabcbb"));
    }
}
