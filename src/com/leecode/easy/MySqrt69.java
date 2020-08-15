package com.leecode.easy;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 通过次数190,050提交次数490,033
 *
 */
public class MySqrt69 {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int i = 1;
        while (i <= x/i){
            i++;
        }
        /*不呢个这样写 i * i可能会超过int范围，结果错误
        while (i * i <= x){
            i++;
        }
         */
        return i-1;
    }
    // 二分法
    public static int mySqrt2(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        long left = 0,right = x/2 +1;
        while (left < right){
            long mid = (left + right + 1)/2;
            long square = mid * mid;
            if (square > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println("mySqrt(8) = " + mySqrt2(8));
    }
}
