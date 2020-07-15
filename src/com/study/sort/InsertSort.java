package com.study.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] numbers = {2,5,1,0,3,4};
        insertSort(numbers);
        for (int number : numbers) {
            System.out.println("bubbleSort(numbers) = " + number);
        }
    }
    public static void insertSort(int[] numbers){
        int n = numbers.length;
        for(int i = 0;i < n-1;i++){
            for (int j = i+1;j > 0;j--){
                if (numbers[j-1] > numbers[j]){
                    int temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }else {
                    break;
                }
            }
        }
    }
}
