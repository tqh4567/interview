package com.exame.test;

// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int n = sc.nextInt();
            List<Integer> list = new ArrayList();
            while(n != 0){
                list.add(n % 10);
                n = n / 10;
            }
            int len = 0;
            while(m != 0){
                len ++;
                m = m / 10;
            }
            int[] ans = new int[list.size()];
            for(int i = 0;i <  list.size();i++ ){
                ans[i] = list.get(i);
            }
            List<List<Integer>> res =new ArrayList<>();
            LinkedList<Integer> list2 = new LinkedList<>();
            dfs(res,ans,list2,0,len);
            System.out.println(res);
        }
        private static void dfs(List<List<Integer>> res, int[] ans, LinkedList<Integer> list2, int start, int len) {
            if (list2.size() == ans.length){
                res.add(new ArrayList<>(list2));
            }
            for (int i = start;i<ans.length;i++){
                list2.add(ans[i]);
                dfs(res, ans, list2, 0, i+1);
                list2.removeLast();
            }
        }
}