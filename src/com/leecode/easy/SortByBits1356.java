package com.leecode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 */
public class SortByBits1356 {
    public static void main(String[] args) {
        SortByBits1356 sort = new SortByBits1356();
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println("sort.sortByBits(arr) = " + Arrays.toString(sort.sortByBits(arr)));
    }
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        // 参照冒泡排序
        List<List<Integer>> resList = new ArrayList<>();
        for (int value : arr) {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            list.add(countOne(value));
            resList.add(list);
        }
        resList.sort((o1, o2) -> {
            if (o1.get(1) == o2.get(1)){
                return o1.get(0) - o2.get(0);
            }else {
                return o1.get(1) - o2.get(1);
            }
        });
        for (int i = 0;i < n;i++){
            arr[i] = resList.get(i).get(0);
        }
        return arr;
    }
    public int countOne(int n){
        int count = 0;
        while(n != 0){
            if((n & 1)== 1){
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }
}
