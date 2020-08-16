package com.leecode.medium.backTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *  
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public  class RestoreIpAddresses93 {
    public static void main(String[] args) {
        System.out.println("restoreIpAddresses(\"25525511135\") = " + new RestoreIpAddresses93().restoreIpAddresses("25525511135"));
    }
    /*暴力解法
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len > 12) return res;
        for (int i = 0; i < len - 3; i++) {
            int num1 = Integer.parseInt(s.substring(0, i + 1));
            if (num1 > 255 || getLen(num1) != i + 1) continue;
            for (int j = i + 1; j < len - 2; j++) {
                int num2 = Integer.parseInt(s.substring(i + 1, j + 1));
                if (num2 > 255 || getLen(num2) != j - i) continue;
                for (int k = j + 1; k < len - 1; k++) {
                    int num3 = Integer.parseInt(s.substring(j + 1, k + 1));
                    if (num3 > 255 || getLen(num3) != k - j) continue;
                    int num4 = Integer.parseInt(s.substring(k + 1, len));
                    if (num4 > 255 || getLen(num4) != len - k - 1) continue;
                    String temp = num1 + "." + num2 + "." + num3 + "." + num4;
                    res.add(temp);
                }
            }
        }
        return res;
    }

    int getLen(int num) {
        if (num == 0)
            return 1;
        return (int) (Math.log(num) / Math.log(10)) + 1;
    }
     */
    // 回溯法
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }
    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

}
