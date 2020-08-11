package com.leecode.easy;

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 *
 */
public class NumWaterBottles1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;
        while (empty >= numExchange){
            int a = empty/numExchange;
            int b = empty%numExchange;
            empty = a + b;
            count += a;

        }
        return count;
    }

    public static void main(String[] args) {
        NumWaterBottles1518 numWaterBottles = new NumWaterBottles1518();
        System.out.println(numWaterBottles.numWaterBottles(15, 4));
    }
}
