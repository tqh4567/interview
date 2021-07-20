package com.leecode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class Merge56 {
    public static void main(String[] args) {
        int[][] interval = {{1,3},{0,0}};
//        int[][] interval = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("merge(interval) = " + Arrays.deepToString(merge(interval)));
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length < 1) return intervals;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int[] temp = intervals[0];
        List<int[]> resList = new ArrayList<>();
        resList.add(temp);
        for(int i = 1;i < intervals.length;i++){
            if(temp[1] < intervals[i][0]){
                resList.add(intervals[i]);
                temp = intervals[i];
            }else{
                temp[0] = Math.min(temp[0],intervals[i][0]);
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }
        }
        int[][] res = new int[resList.size()][2];
        for (int i = 0;i < resList.size();i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
