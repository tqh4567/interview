package com.leecode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 *
 */
public class Insert57 {
    public static void main(String[] args) {
        int[][] intervals = {{13,15},{4,6}};
        int[] newInterval = {7,10};
        System.out.println("insert(intervals,null) = " + Arrays.deepToString(insert(intervals, newInterval)));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int left = newInterval[0],right = newInterval[1];
        boolean placed = false;
        List<int[]> resList = new ArrayList<>();
        for (int i = 0;i < intervals.length;i++){
            if (left > intervals[i][1]){
                resList.add(intervals[i]);
            }else if (right < intervals[i][0]){
                if (!placed){
                    resList.add(new int[]{left,right});
                    placed = true;
                }
                resList.add(intervals[i]);
            }else {
                left = Math.min(intervals[i][0],left);
                right = Math.max(intervals[i][1],right);
            }
        }
        if(!placed){
            resList.add(new int[]{left,right});
        }
        int[][] res = new int[resList.size()][2];
        for (int i = 0;i < resList.size();i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
