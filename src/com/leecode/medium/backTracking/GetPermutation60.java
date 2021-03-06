package com.leecode.medium.backTracking;

import java.util.LinkedList;

/**
 * 给出集合 [1,2,3,。。。,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetPermutation60 {
    /* AC
    static int count = 0;
    public static   String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] nums = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0;i < n;i++){
            nums[i] = i + 1;
        }
        dfs(nums,list,k,n,visited);
        StringBuilder builder = new StringBuilder();
        for (int item : list){
            builder.append(item);
        }
        return builder.toString();
    }

    private static LinkedList<Integer> dfs(int[] nums, LinkedList<Integer> list, int k, int n, boolean[] visited) {
        if (count == k) {
            return list;
        }
        if (list.size() == nums.length){
            count ++;
            return list;
        }
        for (int num = 1;num <=n;num++) {
            if (!visited[num-1]){
                visited[num-1] = true;
                list.add(nums[num-1]);
                list = dfs(nums,list,k,n,visited);
                if (count == k){
                    return list;
                }
                visited[num-1] = false;
                list.removeLast();
            }
        }
        return list;
    }
     */
    static int count = 0;
    public static String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[n];
        dfs(visited,list,k,n);
        StringBuilder builder = new StringBuilder();
        for (int item : list){
            builder.append(item);
        }
        return builder.toString();
    }

    private static void dfs(boolean[] visited, LinkedList<Integer> list, int k, int n) {
        if (count == k) {
            return;
        }
        if (list.size() == n){
            count ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                list.add(i+1);
                dfs(visited,list,k,n);
                if (count == k){
                    return;
                }
                visited[i] = false;
                list.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("getPermutation(3,3) = " +getPermutation(3, 3));
    }
}
