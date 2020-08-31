package com.leecode.easy;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes204 {
    /* 暴力算法超时
    public int countPrimes(int n) {
        int res = 0;
        if (n < 2) return res;
        for (int i = 2;i < n;i++){
            if (isPrimes(i)){
                res ++;
            }
        }
        return res;
    }

    private boolean isPrimes(int n) {
        for (int i = 2;i <= n/2;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

     */
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
    public static void main(String[] args) {
        CountPrimes204 countPrimes = new CountPrimes204();
        System.out.println("countPrimes.countPrimes(10) = " + countPrimes.countPrimes(10));
    }
}
