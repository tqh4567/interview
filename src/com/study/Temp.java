package com.study;

public class Temp {
    public static void main(String[] args) {
        int a=0;
        a=a++;
        System.out.println(a);
        a=++a;
        System.out.println(a);
        a+=2;
        System.out.println(a);
    }
    public static Boolean isOnceEdit(String s1,String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int i = 0,j = 0;
        int count = 0;
        if (Math.abs(length1-length2) > 1){
            return false;
        }
        if (length1 > length2){
            while (i <length1 && j <length2){
                if (s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else {
                    i++;
                    count++;
                }
                i++;
                j++;
            }
            return count <= 1;
        }else if (length1 < length2){
            while (i <length1 && j <length2){
                if (s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else {
                    j++;
                    count++;
                }
                i++;
                j++;
            }
            return count <= 1;
        }else {
            while (i <length1 && j <length2){
                if (s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else {
                    count++;
                    i++;
                    j++;
                }
            }
            return count == 1;
        }
    }
}
