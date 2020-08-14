package com.newcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个正整数N，试求有多少组连续正整数满足所有数字之和为N? (1 <= N <= 10 ^ 9)
 *
 * 输入描述:
 * 5
 *
 * 输出描述:
 * 2
 *
 * 输入例子1:
 * 5
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 */
public class Bilibli2020_02 {
    public static void main(String[] args) {
        String target = "# : a:3#b:8#c:9";
        int res = 0;
        String[] splits = target.split(" ");
        if (splits.length != 3){
            System.out.println(0);
        }else {
            String split = splits[splits.length - 1];
            String[] split1 = split.split(splits[0]);
            for (String s : split1) {
                String[] map = s.split(splits[1]);
                if (map.length == 2){
                    res ++;
                }
            }
            System.out.println(res);
            for (String s : split1) {
                String[] map = s.split(splits[1]);
                if (map.length == 2){
                    System.out.println(map[0] + " "+map[1]);
                }
            }
        }
    }
    // 能通过90%用例
    public List<List<Integer>> getPlans(int n){
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(res,list,1,n,n);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int begin,int target,int n) {
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(list));
        }
        for (int i = begin;i <= n;i++){
            if (i > n/2 + 1 && i != n){
                continue;
            }
            if (list.size() > 0 && list.get(list.size()-1) != i-1){
                continue;
            }
            list.add(i);
            dfs(res,list,i+1,target-i,n);
            list.removeLast();
        }
    }
}
