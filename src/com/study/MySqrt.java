package com.study;

/**
 * 求一个数的平方根，有精度限制
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println("sqrt(3) = " + sqrt1(3,0.01));
    }
    public static double sqrt (double value,double t) {

        double temp = value;

        while( Math.abs(temp*temp - value) > t) {

            temp = (temp + value / temp) / 2.0;
        }
        return temp;


    }
    // 二分法进行判断
    public static double sqrt1 (double value,double t) {
        if (value < 0 || t < 0){
            return 0;
        }
        double left = 0d;
        double right = value;
        double mid = (left + right) / 2;
        double offset = 2*t;
        while (offset > t){
            double temp = mid * mid;
            if (temp > value){
                right = (left + right) / 2;
                offset = temp - value;
            }
            if (temp < value){
                left = (left + right) / 2;
                offset = value - temp;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
}
