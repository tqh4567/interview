package com.study.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {2,5,1,0,3,4};
        for (int number : bubbleSort2(numbers)) {
            System.out.println("bubbleSort(numbers) = " + number);
        }
    }
    // 传统暴力解法
    public static int[] bubbleSort(int[] numbers){
        int n = numbers.length;
        for(int i = 0;i < n;i++){
            for (int j = i+1;j < n;j++){
                if (numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;

    }
    // 优化版冒泡排序，可以减少数据比对的次数，提高效率
    public static int[] bubbleSort2(int[] numbers){
        boolean flag;
        int n = numbers.length;
        for(int i = 0;i < n;i++){
            flag = false;
            for (int j = i+1;j < n;j++){
                if (numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
        return numbers;

    }
}
