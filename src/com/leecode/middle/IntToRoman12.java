package com.leecode.middle;

public class IntToRoman12 {
    public static String intToRoman(int num) {
        int M = 0;
        int D = 0;
        int C = 0;
        int L = 0;
        int X = 0;
        int V = 0;
        int I = 0;
        M = num / 1000;
        num = num % 1000;
        D = num /500;
        num = num % 500;
        C = num / 100;
        num = num % 100;
        L = num / 50;
        num = num %50;
        X = num / 10;
        num = num %10;
        V = num / 5;
        num = num % 5 ;
        I = num;
        StringBuilder builder =  new StringBuilder();
        for(int i = 0;i < M;i++){
            builder.append("M");
        }
        if(D !=0){
            if (C == 4) {
                builder.append("CM");
            }else {
                builder.append("D");
                for(int i = 0;i < C;i++){
                    builder.append("C");
                }
            }
        }else{
            if(C == 4){
                builder.append("CD");
            }else{
                for(int i = 0;i < C;i++){
                    builder.append("C");
                }
            }
        }
        if(L != 0){
            if (X == 4){
                builder.append("XC");
            }else {
                builder.append("L");
                for(int i = 0;i<X;i++){
                    builder.append("X");
                }
            }
        }
        else{
            if(X == 4){
                builder.append("XL");
            }else{
                for(int i = 0;i<X;i++){
                    builder.append("X");
                }
            }
        }
        if(V != 0){
            if (I == 4){
                builder.append("IX");
            }else {
                builder.append("V");
                for (int i = 0; i < I; i++) {
                    builder.append("I");
                }
            }
        }else {
            if (I == 4) {
                builder.append("IV");
            } else {
                for (int i = 0; i < I; i++) {
                    builder.append("I");
                }
            }
        }

        return builder.toString();


    }

    public static void main(String[] args) {
        System.out.println("intToRoman(1994) = " + intToRoman(3));

        String str =
                "";
        System.out.print(str.split(",").length);
    }
}
