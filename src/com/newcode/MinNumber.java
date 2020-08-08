package com.newcode;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MinNumber {
    public static void main(String[] args) {
//        int[] nums = {1,2,4};
//        for (int num:getMinArray(nums)){
//            System.out.println("num = " + num);
//        }
        int i = 0;
        i=i++;
        System.out.println(i);
    }
    /**
     * 小易给你一个包含n个数字的数组。你可以对这个数组执行任意次以下交换操作：
     * 对于数组中的两个下标i,j(1<=i,j<=n)，如果为奇数，就可以交换a_i和a_j。
     *
     * 现在允许你使用操作次数不限，小易希望你能求出在所有能通过若干次操作可以得到的数组中，字典序最小的一个是什么。
     *
     * 输入描述:
     * 第一行一个整数n；
     * 第二行n个整数a_1,a_2,..,a_n，表示数组，每两个数字之间用一个空格分隔。
     * 输入保证。
     *
     * 输出描述:
     * n个整数，每两个整数之间用一个空格分隔，表示得到的字典序最小的数组。
     *
     * 输入例子1:
     * 4
     * 7 3 5 1
     *
     * 输出例子1:
     * 7 3 5 1
     *
     * 输入例子2:
     * 10
     * 53941 38641 31525 75864 29026 12199 83522 58200 64784 80987
     *
     * 输出例子2:
     * 12199 29026 31525 38641 53941 58200 64784 75864 80987 83522
     */
    public static int[] getMinArray(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> singleList = new ArrayList<>();
        List<Integer> doubleList = new ArrayList<>();
        for (int num : nums){
            if(num % 2 == 0){
                doubleList.add(num);
            }else {
                singleList.add(num);
            }
        }
        for (int i = 0;i < n;i++){
            if (nums[i] % 2 == 0){
                if (singleList.size() > 0 && nums[i] > singleList.get(0)){
                    nums[i] = singleList.get(0);
                    singleList.remove(0);
                }
            }else {
                if (doubleList.size() > 0 && nums[i] > doubleList.get(0)){
                    nums[i] = doubleList.get(0);
                    doubleList.remove(0);
                }
            }
        }
        return nums;
    }

    /**
     * 小易有一个长度为n的数字数组a_1, a_2, …, a_n。
     *
     * 问你是否能用这n个数字构成一个环(首尾连接)，使得环中的每一个数字都小于它相邻的两个数字的和(每个数字都必须使用并且每个数字只能使用一次)。
     *
     * 输入描述:
     * 第一行包含一个整数t(1<=t<=10)，表示测试用例的组数。
     * 每个测试用例输入如下：
     * 第一行一个整数n，表示数字的个数；
     * 第二行n个整数a_1, a_2, …, a_n，每两个整数之间用一个空格分隔。
     * 输入数据保证
     *
     * 。
     *
     * 输出描述:
     * 输出应该包含t行，对于每组用例，若能输出"YES"，否则输出"NO"。
     *
     * 输入例子1:
     * 1
     * 5
     * 17 6 17 11 17
     *
     * 输出例子1:
     * YES
     *
     * 输入例子2:
     * 1
     * 3
     * 1 2 4
     *
     * 输出例子2:
     * NO
     */
    public static boolean isCycleArray(int[] nums){
        int n = nums.length;
        if ( n < 3) return false;
        if (nums[n-1] + nums[1] < nums[0]) return false;
        for (int i =1;i < n-1;i++){
            if (nums[i] > (nums[i+1]+nums[i-1])){
                return false;
            }
        }
        return nums[n - 1] <= (nums[n - 2] + nums[0]);
    }
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int n=sc.nextInt();
        if(n < 3) System.out.println("NO");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        if (nums[n-1] + nums[1] < nums[0]) System.out.println("NO");
        for (int i =1;i < n-1;i++){
            if (nums[i] > (nums[i+1]+nums[i-1])){
                System.out.println("NO");
                break;
            }
        }
        if( nums[n - 1] <= (nums[n - 2] + nums[0])){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
