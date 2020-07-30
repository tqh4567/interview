package com.leecode.easy;

public class TwoSum167 {
    /**
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0;i < numbers.length-1;i++){
            int f = getTargrtIndex(numbers,i+1,numbers.length-1,target-numbers[i]);
            if(f!=-1){
                res[0]=i;
                res[1]=f;
            }
        }
        return res;
    }
    public static int getTargrtIndex(int[] numbers,int left,int right,int target){
        while(left <= right){
            int mid = (left + right)/2;
            if(numbers[mid] > target){
                right = mid-1;
            }
            else if(numbers[mid] < target){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
     **/
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0,j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] > target){
                j --;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                return new int[]{i,j};
            }
        }
        return new int[2];
    }
    public static void main(String[] args) {
        int[] numbers = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("twoSum(numbers,9) = " + twoSum(numbers,6));
    }
}
