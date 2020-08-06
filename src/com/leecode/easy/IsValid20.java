package com.leecode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 */
public class IsValid20 {
    // 使用栈进行判断
    public static boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == '('){
                deque.push(')');
            }
            else if (s.charAt(i) == '['){
                deque.push(']');
            }
            else if (s.charAt(i) == '{'){
                deque.push('}');
            }else if (deque.isEmpty() || s.charAt(i) != deque.pop()){
                return false;
            }
            i++;
        }
        if (deque.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("isValid = " + isValid("(){}"));
    }
}
