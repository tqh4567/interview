package com.leecode.medium;

public class MyAtoi08 {
    public static int myAtoi(String str) {
        if( "".equals(str)|| str==null || str.length() < 1) return 0;
        str = str.trim();
        int n = str.length();
        int end = 0;
        if((str.charAt(0) != '+' && str.charAt(0) != '-') && (str.charAt(0) <'0'|| str.charAt(0) > '9'))
            return 0;
        for(int i = 1;i < n;i++){
            if(str.charAt(i) >'9' || str.charAt(i) < '0'){
                break;
            }
            end = i;
        }
        String sub = str.substring(0,end+1);
        if((sub.contains("+") || sub.contains("-")) && sub.length()==1) return 0;
        if(Double.parseDouble(sub) > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(Double.parseDouble(sub) < Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(sub);
    }

    public static void main(String[] args) {
        System.out.println("myAtoi = " + myAtoi("+"));
    }
}
