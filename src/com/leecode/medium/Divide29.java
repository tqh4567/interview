package com.leecode.medium;

public class Divide29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if (divisor == 1) return  dividend;
        if (divisor == -1) return dividend == Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
        if (divisor == Integer.MIN_VALUE && dividend != Integer.MIN_VALUE) return 0;
        if (divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) return 1;
        int res = 0;
        int flag = 1;
        if (dividend >0 && divisor < 0 || dividend < 0 && divisor > 0) {
            flag = -flag;
        }
        if (dividend >0 && divisor < 0 ){
            while(dividend >= -divisor){
                dividend += divisor;
                res++;
            }
        }else if(dividend < 0 && divisor > 0){
            while (dividend <= -divisor) {
                dividend += divisor;
                res++;
            }
        }
        else if(dividend <0 && divisor < 0){
            while (dividend <= divisor) {
                dividend -= divisor;
                res++;
            }
        } else{
            while (dividend >= divisor) {
                dividend -= divisor;
                res++;
            }
        }
        return flag <0 ? -res:res;
    }
//    1038925803
//            -2147483648

    public static void main(String[] args) {
        System.out.println("divide(10,3) = " + divide(-2147483648, 2));
    }
}
