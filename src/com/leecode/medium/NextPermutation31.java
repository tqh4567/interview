package com.leecode.medium;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        for (int c:nextPermutation3(nums)){
            System.out.println("c = " + c);
        }
    }
    // 1 .寻找到第一个最后一位小的数交换能通过50%左右用例 思路不完备比如[4,6,3,7,2]按照下面结果为[2,3,4,6,7]，而实际结果为[4,6,7,2,3]
    // 2. 寻找第一个比其小的，交换将索引以后的排序80%左右，[4,2,0,2,3,2,0]   实际输出为[4,2,2,0,0,2,3]。而预计输出为[4,2,0,3,0,2,2]
    public static int[] nextPermutation2(int[] nums) {
        int n = nums.length;
        int left=-1;
        for (int i = n-1;i >=1;i--){
            for (int j = i-1;j >= 0 ;j--){
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    left = j;
                    j = 0;
                    i = 1;
                }
            }
        }
        if (left == -1){
            Arrays.sort(nums);
        }else {
            Arrays.sort(nums, left + 1, n);
        }
        return nums;
    }
    public static void sort(int[] nums, int begin, int end){
        for (int i = begin;i < end-1;i++){
            for (int j = i + 1;j < end;j++){
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    // 3. 固定某个值，找到其左边第一个比他小的，和右边第一个比他大的，交换。
    public static int[] nextPermutation3(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
