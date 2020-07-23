package com.leecode;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

public class MaxLongSubString {
//    public static int lengthOfLongestSubstring(String s) {
//        if(s ==null || "".equals(s)){
//            return 0;
//        }
//        char[] chars = s.toCharArray();
//        if (chars.length==1){
//            return 1;
//        }
//        if (chars.length==2&&chars[0]==chars[1]){
//            return 1;
//        }
//        int result = 0;
//        Set<Character> set = new HashSet<>();

//        set.add(chars[0]);
//        for(int i = 0;i<chars.length;i++){
//            for(int j=i+1;j<chars.length;j++){
//
//                if(set.size()>0 && set.contains(chars[j])){
//                    set.remove(chars[i]);
//                    break;
//                }
//                set.add(chars[j]);
//
//                result = Math.max(result,set.size());
//            }
//        }
//        return result;
//    }


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
    public static void main(String[] args) {
//        String s="aab";
        int[] s ={10,9,2,5,3,4};
        System.out.println("lengthOfLongestSubstring(s) = " + lengthOfLIS(s));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums.length < 1) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1;i < n;i++){
            int cur = 0;
            for(int j = 0 ; j< i;j++){
                if (nums[i] > nums[j]) {
                    cur = Math.max(cur, dp[j]);
                }
            }
            dp[i] = cur + 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
