package com.leecode.middle;

public class ConvertZ06 {
    public static String convert(String s, int numRows) {
        int n = s.length();
        if(numRows >= n) return s;
        int k = 1;
        StringBuilder str = new StringBuilder();
        for(int i = 0;i < n;i++){
            if(i % (2 * numRows - 2) == 0){
                str.append(s.charAt(i));
            }
        }
        while (k <= numRows-2){
            for(int i = 0;i < n;i++){
                if(i % (2 * numRows - 2) == 0){
                    if (i == 0) {
                        str.append(s.charAt(i + k));
                    } else {
                        str.append(s.charAt(i - k));
                        str.append(s.charAt(i + k));
                    }
                }
            }
            k++;
        }
        for(int i = 0;i < n;i++){
            if(i % (2 * numRows - 2) == 0){
                str.append(s.charAt(i + numRows-1));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // LDREOEIIECIHNTSG
        System.out.println("convert(\"LEETCODEISHIRING\",3) = " + convert("LEETCODEISHIRING", 4));
    }
}
