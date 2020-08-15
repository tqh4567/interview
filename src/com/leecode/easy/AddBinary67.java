package com.leecode.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary67 {
    public static String addBinary(String a, String b) {
        int carry = 0;
        int n1 = a.length()-1;
        int n2 = b.length()-1;
        StringBuilder builder = new StringBuilder();
        while(n1 >= 0 && n2 >= 0){
            int value = Integer.parseInt(a.substring(n1,n1+1)) +Integer.parseInt(b.substring(n2,n2+1)) + carry;
            int current = value % 2;
            carry = value / 2;
            builder.append(current);
            n2--;
            n1--;
        }
        while(n1 >= 0){
            int value = Integer.parseInt(a.substring(n1,n1+1)) + carry;
            int current = value % 2;
            carry = value / 2;
            builder.append(current);
            n1--;
        }
        while(n2 >= 0){
            int value = Integer.parseInt(b.substring(n2,n2+1)) + carry;
            int current = value % 2;
            carry = value / 2;
            builder.append(current);
            n2--;
        }
        if (carry != 0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
