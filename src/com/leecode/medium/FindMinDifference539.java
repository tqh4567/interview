package com.leecode.medium;

import java.util.*;

/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["23:59","00:00"]
 * 输出: 1
 * <p>
 * 备注:
 * <p>
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 */
public class FindMinDifference539 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("02:59");
        System.out.println("findMinDifference(timePoints) = " + findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            minutes[i] = getMinute(timePoints.get(i));
        }
        Arrays.sort(minutes);
        int min = Math.min(Math.abs(minutes[0]+1440 - minutes[timePoints.size() - 1]), Math.abs(minutes[0] - minutes[timePoints.size() - 1]));
        for (int i = 1; i < timePoints.size(); i++) {
            if (min >= minutes[i] - minutes[i - 1]) {
                min = Math.min(Math.abs(minutes[i] - minutes[i - 1]), Math.abs(minutes[i] + 1440 - minutes[i - 1]));
            }
        }
        return min;
    }

    private static int getMinute(String s) {
        int hminute = 0;
        for (int i = 0; i < 2; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hminute = hminute * 10 + s.charAt(i) - '0';
            }
        }
        hminute = hminute * 60;
        int minute = 0;
        for (int i = 3; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                minute = minute * 10 + s.charAt(i) - '0';
            }
        }
        return hminute + minute;
    }
}
