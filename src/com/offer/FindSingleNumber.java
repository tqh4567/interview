package com.offer;

public class FindSingleNumber {
    public static void main(String[] args) {
        int[] ints = new int[]{4,1,4,6};
        int[] numbers = singleNumbers(ints);
        for (int number : numbers){
            System.out.println(number);
        }
    }
    public static int[] singleNumbers(int[] nums) {
        int k = 0;
        for(int num:nums){
            k = k^num;
        }
        int mask = 1;
        while((mask&k) == 0){
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for(int num:nums){
            if((num&mask) == 0){
                a ^=num;
            }else{
                b ^= num;
            }
        }
        return new int[]{a,b};

    }
}
