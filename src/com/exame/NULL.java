package com.exame;

import java.util.Arrays;
import java.util.TreeMap;

public class NULL {

    public static void print(){
        System.out.println("MTDP");
    }
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int n = map.size();
        int[][] arrs = new int[n][2];
        int i = 0;
        for(int key : map.keySet()){
            arrs[i++] = new int[]{key,map.get(key)};
        }
        Arrays.sort(arrs,(o1,o2)->{
            return o2[1] - o1[1];
        });

        System.out.println("ans = " + Arrays.toString(arrs));
        System.out.println("ans = " + map);
    }
}