package com.leecode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class JudgeCircle657 {
    public static boolean judgeCircle(String moves) {
        int len = moves.length();
        int i = 0;
        int l = 0,r = 0,u = 0,d = 0;
        while (i < len){
            if (moves.charAt(i) == 'L'){
               l++;
            }
            if (moves.charAt(i) == 'R'){
               r++;
            }
            if (moves.charAt(i) == 'U'){
               u++;
            }
            if (moves.charAt(i) == 'D'){
               d++;
            }
            i++;
        }
        return l == r && u == d;
    }
}
