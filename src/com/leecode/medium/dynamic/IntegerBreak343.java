package com.leecode.medium.dynamic;

public class IntegerBreak343 {
    // 未考虑溢出情况
    public static int integerBreak(int n) {
        // 类似于剪绳子，最多的3，乘积最大
        if (n < 3) return 1;
        if (n == 3) return 2;
        int x = 3;
        int res = 1;
        int count = n / x;
        int carry = n % x;
        if(carry == 1 && count > 0){
            count = count - 1;
            carry = carry + x;
        }
        // 快幂计算乘积值
        for (int i = 1;i <= count;i++){
            res *= x;
        }
        if (carry != 0){
            return carry * res;
        }
        return res;
    }
    // 未考虑溢出情况,动态规划解法

    /**
     * 创建数组dp，其中dp[i] 表示将正整数 ii 拆分成至少两个正整数的和之后，这些正整数的最大乘积。特别地，0 不是正整数，1 是最小的正整数，0 和 1都不能拆分，因此dp[0]=dp[1]=0。
     *
     * 当 i≥2 时，假设对正整数 ii 拆分出的第一个正整数是 jj（1 \le j < i1≤j<i），则有以下两种方案：
     *
     * 将 ii 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j ×(i−j)；
     *
     * 将 ii 拆分成 j 和 i-j  的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
     *
     *
     * @param n
     * @return
     */
    public static int integerBreak2(int n) {
        // 类似于剪绳子，最多的3，乘积最大
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1] = 0;
        for (int i = 2 ;i <= n;i++){
            int max = 0;
            for (int j = 0;j < i;j++){
                max = Math.max(max,Math.max(j *(i-j),j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("integerBreak(8) = " + integerBreak2(5));
    }
}
