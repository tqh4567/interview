package com.exame;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.nextLine();
        System.out.println(f(s));

    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int count = 0;
        for(int i = n-1;i >= 0;i--){
            if(amount >= coins[i]){
                count = count + amount/coins[i];
                amount = amount%coins[i];
            }
        }
        return amount == 0 ? count : -1;

    }
    public static String f(String s){
        String[] split = s.split(",");
        List<Integer> stand = new ArrayList<>();
        stand.add(0);stand.add(1);stand.add(2);stand.add(3);
        stand.add(4);stand.add(3);stand.add(2);stand.add(1);
        stand.add(5);stand.add(6);stand.add(5);stand.add(7);
        stand.add(8);stand.add(9);stand.add(8);stand.add(7);
        stand.add(5);stand.add(1);stand.add(0);
        int n = split.length;
        List<Integer> list = new ArrayList<>();
        int k = 0;
        list.add(Integer.parseInt(split[0]));
        for (int i = 1; i < n;i++){
            int parseInt = Integer.parseInt(split[i]);
            // 数据进性去重
            if (parseInt == list.get(k)){
                continue;
            }
            list.add(Integer.parseInt(split[i]));
            k++;
        }
        for (int i = 0 ;i < 5;i++){
            if (list.get(i) !=  stand.get(i) ){
                if(list.get(1) > 1) return "Out of path";
                if (list.get(i) > stand.get(i) && list.get(i) > 6){
                    return "Collision";
                }else if(list.get(i) > stand.get(i) && list.get(i) > 4 && list.get(i) < 6) {
                    return "Bad path";
                }
            }
        }
        for (int i = 5 ;i < 8;i++){
            if (list.get(i) !=  stand.get(i) ){
                if (list.get(i) > stand.get(i) && list.get(i) > 6){
                    return "Collision";
                }else if(list.get(i) < stand.get(i)) {
                    return "Out of path";
                }
            }
        }
        for (int i = 8 ;i < 10;i++){
            if (list.get(i) !=  stand.get(i) ){

                return "Bad path";

            }
        }
        for (int i = 10 ;i < 12;i++){
            if (list.get(i) !=  stand.get(i) ){

                return "Bad path";

            }
        }
        for (int i = 12 ;i < 15;i++){
            if (list.get(i) !=  stand.get(i) ){
                if(list.get(i) < stand.get(i) && list.get(i) < 5){
                    return "Collision";
                }else if(list.get(i) < stand.get(i) && list.get(i) == 5){
                    return "Bad path";
                }

            }
        }
        return "Success";
    }

}