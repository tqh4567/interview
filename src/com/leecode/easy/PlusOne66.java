package com.leecode.easy;

import java.util.Arrays;

public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n+1];
        // 进位
        int carry = (digits[n-1] + 1)/10;
        int cur = (digits[n-1] + 1)%10;
        res[n] = cur;
        for(int i = n-2;i>= 0;i--){
            cur = (carry+digits[i])%10;
            carry = (carry+digits[i])/10;
            res[i+1] = cur;
        }
        if(carry == 1){res[0] = carry;}
        else{
            return Arrays.copyOfRange(res, 1,n+1);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {9,9,9,9,9,6};
        for (int num : plusOne(nums)) {
            System.out.println("plusOne(nums) = " + num);
        }
    }
}
