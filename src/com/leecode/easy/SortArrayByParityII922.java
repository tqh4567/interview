package com.leecode.easy;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII922 {
    public static void main(String[] args) {
        int[] nums = {2,3};
        System.out.println("sortArrayByParityII(nums) = " + Arrays.toString(sortArrayByParityII(nums)));
    }
    public static int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length < 1) return A;
        int i = 0,j = 1;
        while(i <A.length && j < A.length){
            while(j < A.length && A[j] % 2 == 1){
                j+=2;
            }
            while(i < A.length && A[i] % 2 == 0){
                i+=2;
            }
            if(i > A.length || j > A.length){
                return A;
            }
            int temp = A[j];
            A[j] = A[i];
            A[i] = temp;
            i+=2;
            j+=2;
        }
        return A;
    }
}
