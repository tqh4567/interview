package com.newcode;

/**
 * 牛牛有两个长度为nn的数组a, ba,b，牛牛希望统计有多少数对(l, r)(l,r)满足：
 * 1，0 \leq l \leq r \leq n - 10≤l≤r≤n−1
 * 2，\sum_{i= l}^{r}{a_i} = b_l + b_r∑
 * i=l
 * r
 * ​
 *  a
 * i
 * ​
 *  =b
 * l
 * ​
 *  +b
 * r
 * ​
 *
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4],[2,1,4,5]
 * 输出
 * 复制
 * 4
 * 说明
 * 满足条件的数对有(0, 1), (0, 2), (1, 1), (1, 2)(0,1),(0,2),(1,1),(1,2)
 */
public class CountLR {
    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        int [] b = {2,1,4,5};
        System.out.println("countLR(a,b) = " + countLR(a, b));

    }
    public static int countLR (int[] a, int[] b) {
        // write code here
        int n = a.length;
        int res = 0;
        for(int i = 0;i < n;i++){
            int sum = 0;
            for(int j = i;j < n;j++){
                sum+= a[j];
                if(sum == b[i]+b[j]){
                    res++;
                }
            }
        }
        return res;
    }
}
