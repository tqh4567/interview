package com.leecode.medium.backTracking;

public class CountNumbersWithUniqueDigits357 {
    // 回溯算法，复杂度高
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        boolean[] visited = new boolean[10];
        return dfs(n,visited,0);
    }

    private int dfs(int n,  boolean[] visited,int begin) {
        int count = 0;
        if (begin != n){
            for (int i = 0; i< 10;i++){
                if (i == 0 && n > 1 && begin == 1){
                    continue;
                }
                if (visited[i]){
                    continue;
                }
                visited[i] = true;
                count += dfs(n,visited,begin+1)+1;
                visited[i] = false;
            }
        }
        return count;
    }
    // 动态压缩
    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) return 1;
        int frist = 10, second = 9 * 9;
        for (int i = 2;i<=n;i++){
            frist += second;
            second *= 10-i;
        }
        return frist;
    }
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits357 countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits357();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits2(3));
    }
}
