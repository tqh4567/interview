package com.leecode.easy;

public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
//            if(strs.length == 0)
//                return "";
//            String ans = strs[0];
//            for(int i =1;i<strs.length;i++) {
//                int j=0;
//                for(;j<ans.length() && j < strs[i].length();j++) {
//                    if(ans.charAt(j) != strs[i].charAt(j))
//                        break;
//                }
//                ans = ans.substring(0, j);
//                if(ans.equals(""))
//                    return ans;
//            }
//            return ans;
        if(strs.length <= 0) return "";
        int m = strs.length;
        String res = strs[0];
        for(int i = 1;i < m;i++){
            int j = 0;
            while (j < strs[i].length() && j < res.length()){
                if (res.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            res = res.substring(0,j);
            if (res.equals("")){
                return res;
            }
        }
        return res;
    }
    /*
    * if(strs.length <= 0) return "";
        int m = strs.length;
        int n = strs[0].length();
        StringBuilder builder = new StringBuilder();

        for(int i = 1;i < m;i++){
            int j = 0;
            for(;j < n && j < strs[i].length;j++){
                if(strs[i].charAt(j) != strs[i-1].charAt(j)){
                    if (j == 0) return "";
                    return builder.toString();
                }
            }
            builder.append(strs[0].charAt(j));
        }
        return builder.toString();
    }*/

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
    }
}
