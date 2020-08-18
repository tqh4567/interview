package com.newcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class huaWei {
    /**
     *有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
     * 方法如下：
     * 先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
     * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
     * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
     *
     */
    public static int change(int n){
        int count = 0;
        while (n >= 3){
            int temp = n / 3;
            count += temp;
            n = n % 3 +temp;
        }
        if (n == 2){
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            System.out.println(changerNumber(s));
        }
    }
    public static long changerNumber(String s){
        String target =s.split("x")[1];
        int n = target.length();
        long res = 0;
        for (int i = 0;i < n;i++){
            if (target.charAt(i) >= '0' && target.charAt(i) <= '9') {
                res = res * 16 + target.charAt(i) - '0';
            }else if (target.charAt(i) >= 'A' && target.charAt(i) <= 'F'){
                res = res * 16 + target.charAt(i) - 'A' + 10;
            }
        }
        return res;
    }
    public static void sortArray(int[] nums){
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.contains(num)){
                set.add(num);
                System.out.println(num);
            }
        }

    }


}
