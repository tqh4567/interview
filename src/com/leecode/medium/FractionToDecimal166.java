package com.leecode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * -1
 * -2147483648
 * 2147483647
 * 37
 */
public class FractionToDecimal166 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2147483647,37));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        boolean flag = false;
        long x = numerator;
        long y = denominator;
        if (x * y < 0){
            flag = true;
        }
        if (x < 0){
            x = -x;
        }
        if (y < 0){
            y = -y;
        }
        long carry = 0;
        StringBuilder builder = new StringBuilder();
        if (flag){
            builder.append("-");
        }
        HashMap<Long,Integer> map = new HashMap<>();
        long number = x / y;
        carry = x % y;
        x = carry;
        if (carry != 0) {
            builder.append(number).append(".");
        }else {
            builder.append(number);
        }
        int k = builder.indexOf(".")+1;
        while (x > 0){
            x = x * 10;
            if (map.containsKey(x)){
                return builder.insert(map.get(x),"(").append(")").toString();
            }else {
                map.put(x,k++);
            }
            long cur = x / y;
            carry = x % y;
            x = carry;
            builder.append(cur);
        }
        return builder.toString();
    }
}
