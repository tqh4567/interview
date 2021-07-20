package com.leecode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * [943,790,427,722,860,550,225,846,715,320]
 * [943,715,427,790,860,722,225,320,846,550]
 */
public class RelativeSortArray1122 {
    public static void main(String[] args) {
        int[] arr1 = {943,790,427,722,860,550,225,846,715,320};
        int[] arr2 = {943,715,427,790,860,722,225,320,846,550};
        System.out.println("relativeSortArray(arr1,arr2) = " + Arrays.toString(relativeSortArray(arr1, arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr2.length;i++){
            map.put(arr2[i],i);
        }
        for (int i = 0;i < arr1.length;i++){
            for (int j = i+1;j < arr1.length;j++){
                if(map.getOrDefault(arr1[i],arr2.length) > map.getOrDefault(arr1[j],arr2.length)){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        int k = 0;
        while (k < arr1.length && map.containsKey(arr1[k])){
            k++;
        }
        Arrays.sort(arr1,k,arr1.length);
        return arr1;


    }
}
