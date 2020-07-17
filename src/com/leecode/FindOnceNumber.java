package com.leecode;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class FindOnceNumber {
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }

    /**
     * 查询主要元素，元素个数超过数组容量的一半
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count =1;
        map.put(nums[0],1);
        int obj = nums[0];
        for (int i = 1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if (map.get(nums[i])>count){
                    obj = nums[i];
                    count=map.get(nums[i]);
                }
            }else {
                map.put(nums[i],1);
            }
        }
        if(count>nums.length/2){
            return obj;
        }
        return 0;
    }

    /**
     * 查找二维数组中的元素每个数字是否存在
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * @param matrix
     * @param target
     * @return
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length<1) return false;
        int l = matrix.length;
        int w = matrix[0].length;
        int i = 0,j = w-1;
        while(i<l && j>=0){
            if(matrix[i][j]<target){
                i++;
            }else if(matrix[i][j]>target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m-1,j = n-1,k = m+n-1;
//        while ((i >= 0) &&( j >= 0))
//        nums1[k--] = (nums1[i] < nums2[j]) ? nums2[j--] : nums1[i--];
//        System.arraycopy(nums2,0,nums1,0,j+1);
        /**
         * 暴力解法
         */
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
        /*"============================="*/
        int[] temp = new int[m+n];
        int i = 0, j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] > nums2[j]){
                temp[k++] = nums2[j];
                j++;
            }else {
                temp[k++] = nums1[i];
                i++;
            }

        }
        while (i < m){
            temp[k++] = nums1[i];
            i++;
        }
        while (j < n){
            temp[k++] = nums2[j];
            j++;
        }
        nums1 = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};int m = 3;
        int[] nums2 = {2,5,6};     int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println("searchMatrix(ints) = " + translateNum(12258));
    }
    public static int translateNum(int num) {
        int cur = num;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while(cur / 10 != 0){
            list.add(cur % 10);
            cur = cur/10;
        }
        list.add(cur);
        int[] ints = new int[list.size()];
        for(int i = list.size()-1;i>=0;i--){
            ints[list.size()-i-1] = list.get(i);
        }
        int j = 0;
        while(j < list.size()){
            if(ints[j] >2){
                j++;
            }else if (ints[j] < 2){
                count += 2;
                j = j+2;
            }else {
                if (ints[j+1] <= 5){
                    count += 2;
                    j = j+2;
                }
                j++;
            }
        }
        return count;
    }
}
