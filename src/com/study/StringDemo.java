package com.study;

import java.util.Arrays;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//        String str5 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str5.intern() .equals(str5));
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
//
//        String str3 = new StringBuilder("string").append("va").toString();
//        System.out.println(str3.intern() == str3);
//        System.out.println(" ============================================= ");
//        String a1 = "AA";//在常量池上创建常量AA
//        String a2 = "AA";//直接返回已经存在的常量AA
//        System.out.println(a1 == a2); //true
//
//        String a3 = new String("AA");    //在堆上创建对象AA
//        a3.intern(); //在常量池上创建对象AA的引用
//        String a4 = "AA"; //常量池上存在引用AA，直接返回该引用指向的堆空间对象，即a3
//        System.out.println(a3 == a4); //false,如果这个例子不理解，请看完整篇文章再回来看这里

//        System.out.println(" ============================================= ");
//        String a5 = new String("AA");
//        System.out.println(a5 == a5.intern()); //false
//
//        String a6 = "AA";
//        System.out.println(a6 == a6.intern()); //true

//        String s1 = "abc";
//        String s2 = "a";
//        String s3 = "bc";
//        String s4 = s2 + s3;
//        System.out.println(s1 == s4);//false
//        String s1 = "abc";
//        String s4 = "a" + "bc";
//        System.out.println(s1 == s4);//true
        int[] cons ={3,4,5,6,7,0,1,2};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            } else {
                System.out.println(a + b);
            }
        }
    }
    /**
    public static int searchIndex(int[] nums,int target){
        int n = nums.length;
        int i = 0,j = n-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] > target){
                if(nums[j] > target && nums[i] > target){
                    i = mid + 1;
                }
                else if (nums[j] < target){
                    j = mid -1;
                }else {
                    return j;
                }
            }else if (nums[mid] < target){
                i = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int changeCons(int[] cons,int money){
        int[] dp = new int[money+1];
        Arrays.fill(dp,money+1);
        dp[0] = 0;
        for (int i = 1;i <= money;i++){
            for (int con:cons){
                if (i >= con){
                    dp[i] = Math.min(dp[i],1+dp[i-con]);
                }
            }
        }
        if(dp[money] == money+1){
            return -1;
        }else {
            return dp[money];
        }

    }
     **/
}
