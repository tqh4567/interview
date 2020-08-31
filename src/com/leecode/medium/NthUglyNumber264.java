package com.leecode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 */
public class NthUglyNumber264 {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0,three = 0,five = 0;
        for (int i = 1; i < n;i++){
            dp[i] = Math.min(2*dp[two],Math.min(3*dp[three],5*dp[five]));
            if (dp[i] % 2 == 0) two++;
            if (dp[i] % 3 == 0) three++;
            if (dp[i] % 5 == 0) five++;
        }
        return dp[n-1];
    }

    /**
     * 编写一段程序来查找第 n 个超级丑数。
     *
     * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
     *
     * 示例:
     *
     * 输入: n = 12, primes = [2,7,13,19]
     * 输出: 32
     * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
     * 说明:
     *
     * 1 是任何给定 primes 的超级丑数。
     *  给定 primes 中的数字以升序排列。
     * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
     * 第 n 个超级丑数确保在 32 位有符整数范围内。
     *
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        int[] count = new int[1000];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n;i++){
            int min = Integer.MAX_VALUE;
            for (int prime : primes) {
                min = Math.min(prime * dp[count[prime]], min);
            }
            dp[i] = min;
            for (int prime : primes) {
                if (dp[i] % prime == 0) count[prime]++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        NthUglyNumber264 nthUglyNumber = new NthUglyNumber264();
        int[] primes = {2,7,13,19};
        System.out.println("nthUglyNumber.nthSuperUglyNumber(12,primes) = " + nthUglyNumber.nthSuperUglyNumber(12, primes));
//        System.out.println("nthUglyNumber.nthUglyNumber(10) = " + nthUglyNumber.nthUglyNumber(10));
    }
}
