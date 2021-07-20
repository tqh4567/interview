package com.leecode.medium.array;

import java.util.*;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，
 * 因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 */
public class FindMinArrowShots452 {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("findMinArrowShots(points) = " + findMinArrowShots(points));
        Random random = new Random();
        for(int i = 0;i < 7;i++){
            int nextInt = random.nextInt(5)+1;
            System.out.println("random = " + nextInt);
        }
    }
    public static int findMinArrowShots(int[][] points) {
        if(points.length < 1 || points[0].length < 1) return 0;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(points,(o1, o2)->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < points.length){
            while (i < points.length-1 && points[i+1][0] <= points[i][1]){
                points[i+1][0] = Math.min(points[i+1][0],points[i][0]);
                points[i+1][1] = Math.max(points[i+1][1],points[i][1]);
                i++;
            }
            list.add(points[i]);
            i++;
        }
        return list.size();
    }
}
