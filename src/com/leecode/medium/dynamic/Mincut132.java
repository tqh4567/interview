package com.leecode.medium.dynamic;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 */
public class Mincut132 {
    /** 超时
    public int minCut(String s) {
        if (s.length() == 0) return 0;
        // 参照131题，返回res最小长度减一即为结果
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        backTrack(res,list,0,s,len);
        int min = len;
        for (List<String> re : res) {
            min = Math.min(min, re.size());
        }
        return min-1;
    }

    private void backTrack(List<List<String>> res, LinkedList<String> list, int start, String s, int len) {
        if (start == len){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i < len;i++){
            if (!isPalindrom(s,start,i)){
                continue;
            }
            list.add(s.substring(start,i+1));
            backTrack(res,list,i+1,s,len);
            list.removeLast();
        }
    }
    private boolean isPalindrom(String s, int start, int i) {
        while (start < i){
            if (s.charAt(start) != s.charAt(i)){
                return false;
            }
            start++;
            i--;
        }
        return true;
    }
     **/
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < len; i++) {
            if (checkPalindrome(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            // 当 j == i 成立的时候，s[i] 就一个字符，一定是回文
            // 因此，枚举到 i - 1 即可
            for (int j = 0; j < i; j++) {
                if (checkPalindrome(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];

    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Mincut132 mincut = new Mincut132();
        System.out.println("mincut.minCut(\"aab\") = " + mincut.minCut("ababababababababababababcbabababababababababababa"));
    }
}
