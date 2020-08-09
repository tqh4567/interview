package com.leecode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *  示例:https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        if(digits.contains("1") || digits.contains("*") || digits.contains("0") || digits.contains("#")){
            return res;
        }
        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        StringBuilder builder = new StringBuilder();
        dfs(0,digits,res,builder,map);
            return res;
    }

    /**
     * 那我们回溯法的解体框架是什么呢，解决一个回溯问题，实际上就是一个决策树的遍历过程。一般来说，我们需要解决三个问题：
     *
     * 路径：也就是已经做出的选择。
     * 选择列表：也就是你当前可以做的选择。
     * 结束条件：也就是到达决策树底层，无法再做选择的条件。
     * 我们所使用的框架基本就是：
     *
     * 其中最关键的点就是：在递归之前做选择，在递归之后撤销选择。
     *
     *
     * LinkedList result = new LinkedList();
     * public void backtrack(路径，选择列表){
     *     if(满足结束条件){
     *         result.add(结果);
     *     }
     *     for(选择：选择列表){
     *         做出选择;
     *         backtrack(路径，选择列表);
     *         撤销选择;
     *     }
     * }
     *
     */
    private void dfs(int start, String digits, List<String> res, StringBuilder builder, HashMap<Character,char[]> map) {
        if (start == digits.length()){
            res.add(builder.toString());
            return;
        }
        char aChar = digits.charAt(start);
        char[] chars1 = map.get(aChar);
        for (int i = 0;i < chars1.length;i++){
            builder.append(chars1[i]);
            dfs(start+1,digits,res,builder,map);
            builder.deleteCharAt(builder.length()-1);
        }

    }
}
