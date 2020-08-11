package com.leecode.medium;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply43 {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0'){
            return "0";
        }
        if (num2.length() == 1 && num2.charAt(0) == '0'){
            return "0";
        }
        int n = num2.length();
        String[] strings =new String[n];
        for (int i = n-1;i >= 0;i--){
            StringBuilder builder = multiplyOne(num1, num2.substring(i, i + 1));
            builder.reverse();
            for (int j = i;j < n-1;j++){
                builder.append(0);
            }
            strings[i] = builder.toString();
        }
        return addString(strings);
    }
    public String addString(String[] strings){
        String result = "";
        for (String s : strings){
            result = addTwoString(result,s);
        }
        return result;
    }
    public String addTwoString(String num1, String num2) {
        int carry = 0;
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        StringBuilder builder = new StringBuilder();
        while(n1 >= 0 && n2 >= 0){
            int value = Integer.parseInt(num2.substring(n2,n2+1)) +Integer.parseInt(num1.substring(n1,n1+1)) + carry;
            int current = value % 10;
            carry = value / 10;
            builder.append(current);
            n2--;
            n1--;
        }
        while(n1 >= 0){
            int value = Integer.parseInt(num1.substring(n1,n1+1)) + carry;
            int current = value % 10;
            carry = value / 10;
            builder.append(current);
            n1--;
        }
        while(n2 >= 0){
            int value = Integer.parseInt(num2.substring(n2,n2+1)) + carry;
            int current = value % 10;
            carry = value / 10;
            builder.append(current);
            n2--;
        }
        if (carry != 0){
            builder.append(carry);
        }
        return builder.reverse().toString();

    }
    public StringBuilder multiplyOne(String num1, String num2) {
        int carry = 0;
        int n = num1.length();
        StringBuilder builder = new StringBuilder();
        for (int i = n-1;i >= 0;i--){
            int value = Integer.parseInt(num2) * Integer.parseInt(num1.substring(i,i+1)) + carry;
            int current = value % 10;
            carry = value / 10;
            builder.append(current);
        }
        if (carry != 0){
            builder.append(carry);
        }
        return builder;
    }

    public static void main(String[] args) {
        Multiply43 multiply = new Multiply43();
//        System.out.println(multiplyEnd("223", "6"));
//        System.out.println(addStrings("", "936"));
        System.out.println(multiply.multiply("2", "4"));
    }
}
