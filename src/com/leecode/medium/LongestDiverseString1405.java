package com.leecode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 *
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 *
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *  
 *
 * 提示：
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-happy-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestDiverseString1405 {
    public String longestDiverseString(int a, int b, int c) {
        int[] nums = new int[]{a,b,c};
        StringBuilder sb = new StringBuilder();
        //last访问下标
        int last = -1;
        //重复last则noVis下标不能再访问了
        int noVis = -1;
        while (true){
            int max = 0 ;
            int index = -1;
            for (int i = 0; i < 3; i++) {
                //不访问noVis下标
                if(i!=noVis && nums[i] > max){
                    max = nums[i];
                    index = i;
                }
            }
            if(index == -1){
                break;
            }
            nums[index]--;
            if(last == index){
                //重复两次无法继续访问
                noVis = last;
            }else {
                //不是重复的清除无法访问标记
                noVis = -1;
            }
            last = index;
            sb.append((char)('a'+index));
        }
        return sb.toString();
    }
}
