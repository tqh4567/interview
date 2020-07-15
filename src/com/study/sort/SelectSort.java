package com.study.sort;

public class SelectSort {
    public static int[] select_sort(int[] nums){
        int min = 0,n = nums.length;
        for (int i = 0;i < n;i++){
            for (int j = i + 1;j < n;j++){
                if (nums[min] > nums[j]){
                    min = j;
                }
            }
            if (min != i){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] numbers = {2,5,1,0,3,4};
        for (int number : select_sort(numbers)) {
            System.out.println("bubbleSort(numbers) = " + number);
        }
    }
}
