package com.leecode;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumberSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result={};
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0;i<length;i++){
            int hope = target-nums[i];
            if(map.containsKey(hope)){
                result=new int[]{map.get(hope),i};
            }
            map.put(nums[i],i);
        }
        return result;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 字符串压缩
     **/
    public static String compressString(String S) {
        int i = 0;
        StringBuilder  stringBuffer = new StringBuilder ();
        while (i < S.length()){
           int j = i;
            while (j < S.length()&&S.charAt(i) == S.charAt(j)){
                j++;
            }
            stringBuffer.append(S.charAt(i));
            stringBuffer.append(j-i);
            i=j;
        }
        if (stringBuffer.toString().length() < S.length()){
            return stringBuffer.toString();
        }
        return S;
    }

    /**
     * 90度旋转二维数组
     * @param matrix
     * 未完成
     */
    public static int[][] rotate(int[][] matrix) {
        for (int i = 0;i < matrix.length;i++){
            for (int j = i;j < matrix.length;j++){
                int temp ;
                temp = matrix[j][i];
                matrix[j][i] = matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i] = temp;
            }
        }
        return matrix;
    }

    /**
     * s是否回文
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome(String s) {
        if (s==null) return false;
//        if ("".equals(s)) return true;
        int length = s.length();
//        Map<Character,Integer> map = new HashMap<>();
//        int sum = 0;
//        map.put(s.charAt(0),1);
//        for (int i = 1;i < length;i++){
//            if (map.containsKey(s.charAt(i))){
//                if (map.get(s.charAt(i)) > 0) {
//                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
//                }else {
//                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//                }
//            }
//            else {
//                map.put(s.charAt(i),1);
//            }
//        }
//        for (Character cs:map.keySet()){
//            sum = sum + map.get(cs);
//        }
//        if (s.length() % 2 == 0){
//            return sum==0;
//        }
//        else {
//            return sum==1;
//        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0;i < length;i++){
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size() <=1;
    }
    public static boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0;i<astr.length();i++){
            set.add(astr.charAt(i));
        }
        return set.size() == astr.length();
    }

    /**
     * 字符重排
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] flag = new int[128];
        for (int i = 0;i < s1.length();i ++){
           flag[s1.charAt(i)]++;
           flag[s2.charAt(i)]--;
        }
        for (int j = 0;j < flag.length;j++){
           if (flag[j] != 0){
               return false;
           }
        }
        return true;
    }
    private static String replaceSpaces(String S, int length) {
//        if (string.length() < 1) return string;
//        String subString = string.substring(0,length);
//        return subString.replaceAll(" ", "%20");
        char[] chs = S.toCharArray();
        int i = length-1, j = S.length()-1;
        while(i>=0){
            if(chs[i]==' '){
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            }else{
                chs[j--] = chs[i];
            }
            i--;
        }
        return String.valueOf(chs,j+1, S.length()-j-1);
    }
    public static void main(String[] args) {
        String s1 = "e13";
//        String s2 = "ab";
//        int[][] ints= {{1,2},{3,4}};
        int[] nums = {2,3,1,0,2,5,3};
        int a= (int) Math.sqrt(10);
        System.out.println("isUnique(s1,s2) = " + isNumber(s1));
    }
    public static boolean isNumber(String s) {

        return true;
    }
    public static int parseStringToInteger(String s){
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;//是否为正数
        String value = s.trim();
        char[] chars = value.toCharArray();
        if(chars[0] != '-' )

        for(int i = 0;i < s.length();i++){
            if(chars[i] == '-' && flag){
                flag = false;
                if(!(chars[i+1] >= '0' && chars[i+1] <= '9')){
                    return 0;
                }
            }
            if(chars[i] >= '0' && chars[i] <= '9'){
                stringBuilder.append(chars[i]);
                if(!(chars[i+1] >= '0' && chars[i+1] <= '9')){
                    break;
                }
            }

        }
        double parseDouble = Double.parseDouble(stringBuilder.toString());
        if(parseDouble > Integer.MAX_VALUE && flag){
            return Integer.MAX_VALUE;
        }
        if(parseDouble > Integer.MAX_VALUE && !flag){
            return Integer.MIN_VALUE;
        }

        return flag?Integer.parseInt(stringBuilder.toString()):-Integer.parseInt(stringBuilder.toString());
    }
    public static int findRepeatNumber(int[] nums) {
        int[] flags = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            flags[nums[i]] = flags[nums[i]]+1;
        }
        for(int j = 0;j < flags.length;j++){
            if(flags[j] > 1){
                return j;
            }
        }
        return -1;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            List<Integer> list = new ArrayList<>();
            // int[] ints = new int[3];
            // Map<Integer,Integer> map1 = new HashMap<>();
            // map.put(nums[i],map1);
            for(int j = i+1;j < nums.length;j++){
                // int hope = -(nums[i]+nums[j]);
                // if(map1.containsKey(hope)){

                // }
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                    }
                }
                result.add(list);
            }

        }
        return result;
    }
    public static int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(target,0);
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        return map.get(target);
    }
    public static int[][] findContinuousSequence(int target) {
        int i = 1,j = 1;
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        while(i <= target/2){
            if(sum < target){
                sum = sum + j;
                j++;
            }else if(sum > target){
                sum = sum - i;
                i ++;
            }else{
                int[] ints = new int[j-i];
                for(int k = i;k < j;k++){
                    ints[k-i] = k;
                }
                result.add(ints);
                sum = sum -i;
                i++;
            }
        }
        return result.toArray(new int [result.size()][]);
        /*
        int i = 1; // 滑动窗口的左边界
    int j = 1; // 滑动窗口的右边界
    int sum = 0; // 滑动窗口中数字的和
    List<int[]> res = new ArrayList<>();

    while (i <= target / 2) {
        if (sum < target) {
            // 右边界向右移动
            sum += j;
            j++;
        } else if (sum > target) {
            // 左边界向右移动
            sum -= i;
            i++;
        } else {
            // 记录结果
            int[] arr = new int[j-i];
            for (int k = i; k < j; k++) {
                arr[k-i] = k;
            }
            res.add(arr);
            // 左边界向右移动
            sum -= i;
            i++;
        }
    }

    return res.toArray(new int[res.size()][]);
         */
    }
    public static int minSubArrayLen(int s, int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (int key:map.keySet()){
            if(map.get(key) > nums.length/2){
                return key;
            }
        }
        return 0;

    }
    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Boolean> map = new HashMap<>();
        for (Character c: chars){
            map.put(c,!map.containsKey(c));
        }
        for (Character character:map.keySet()){
            if(map.get(character)){
                return character;
            }
        }
        return ' ';
    }

/**     int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
 **/
public int[] twoSum2(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer,Integer> map = new HashMap<>();
    for(int num:nums){
        int hope = target-num;
        if(map.containsKey(hope)){
            result[0] = num;
            result[1] = map.get(hope);
            return result;
        }
        else{
            map.put(hope,num);
        }
    }
    return result;
}
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length()-1 , j=i;
        while (i >= 0){
            while(i >= 0 && s.charAt(i) != ' ') i--;
            stringBuilder.append(s.substring(i + 1, j + 1) + " ");
            while(i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return stringBuilder.toString().trim();
    }

    private static String changeString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = string.length()-1;i>=0;i--){
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }


}
