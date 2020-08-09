package com.leecode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCasePermutation784 {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        char[] chars = s.toCharArray();
        dfs(0,chars,res);
        return res;
    }

    private void dfs(int start, char[] chars,List<String> res) {
        if (start == chars.length){
            res.add(new String(chars));
            return;
        }
        if (chars[start] >= '0' && chars[start] <= '9') {
            dfs(start+1,chars,res);
        }else {
            dfs(start+1,chars,res);
            if (chars[start] >= 'a' && chars[start] <= 'z'){
                char upperCase = Character.toUpperCase(chars[start]);
                chars[start] = upperCase;
            }else {
                char lowerCase = Character.toLowerCase(chars[start]);
                chars[start] = lowerCase;
            }
            dfs(start+1,chars,res);
        }

    }
}
