package com.leecode.easy;

public class LengthOfLastWord58 {
    public static int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println("lengthOfLastWord(\"hello word\") = " + lengthOfLastWord("ab bb bb "));
    }
}
