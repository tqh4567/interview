package com.huawei;


import java.util.*;

public class Main {
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s1 = sc.next();
//            String s2 = sc.next();
            String s1 = "DKSq8qykpgKIZxiRKmQ9QkZt909PffE6Gyfc57dBx7p20D42bWJRzKqGGCzzQ4p7Z32Dsx2Cf8G2841lPuAZNb";
            String s2 = "K0fHodOVFlbl220ov260TPOrmZ328d1E89OatcL88EXr622RdklXtXazO7wMoc6DEKU45eQ5VBUy2YFjgJX";
            String concat = s1.concat(s2);
        char[] chars = concat.toCharArray();
        char[]r1 = new char[chars.length / 2];
        //奇数位
        char[]r2 = new char[chars.length - chars.length / 2];
        for (int i = 0, j = 0, k = 0; i < chars.length; i++){
            if ( i % 2 == 0){
                r2[j] = chars[i];
                j++;
            }else {
                r1[k] = chars[i];
                k++;
            }
        }
        Arrays.sort(r1);
        Arrays.sort(r2);
        System.out.println(processString(r1,r2));
//        }
    }
    public static String processString(char[] r1 ,char[] r2){
        StringBuilder builder = new StringBuilder();

        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');map.put('1','8');map.put('2','4');map.put('3','C');
        map.put('4','2');map.put('5','A');map.put('6','6');map.put('7','E');
        map.put('8','1');map.put('9','9');map.put('a','5');map.put('b','D');
        map.put('c','3');map.put('d','B');map.put('e','7');map.put('f','F');
        for (int i = 0, j = 0, k = 0; i < r1.length+r2.length; i++){
//            if (i % 2 == 0){
//                //注意存在码表不包含的情况，使用原值
//                ch[i] = map.getOrDefault(r2[j], r2[j]);
//                j++;
//            }else {
//                ch[i] = map.getOrDefault(r1[k], r1[k]);
//                k++;
//            }
        }
        return builder.toString();
    }
    public static int[] fin(int m){
        int[] res = new int[2];
        for (int i = 2;i <= m/2 ;i++){
            if (i % 2 == 0){
                continue;
            }
            if (isSimpleNumber(i) && isSimpleNumber(m-i)){
                res[0] = i;
                res[1] = m - i;
            }
        }
        return res;
    }

    private static boolean isSimpleNumber(int n) {
        for (int i = 2;i <= n/2;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 题目描述
     *
     * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
     *
     *
     * 输入
     *
     * 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
     *
     *
     * 样例输入
     *
     * 7 3
     *
     *
     * 样例输出
     *
     * 8
     *
     *
     * /**
     *
     * * 计算放苹果方法数目
     *
     *
     * * 输入值非法时返回-1
     *
     * * 1 <= m,n <= 10
     *
     * * @param m 苹果数目
     *
     * * @param n 盘子数目数
     *
     * * @return 放置方法总数
     *
     * *
     *
     * */
    public static int countA(int m, int n){
        if(m==0 || n==1)
            return 1;
        if(m<n)
            return countA(m,m);
        return countA(m,n-1)+countA(m-n,n);
    }

    private static void backTracking(int[] nums, LinkedList<Integer> list, int start, int m, int n) {
        if (m < 0) return;
        if (list.size() > n) return;
        if (list.size() == n && m == 0){
            count++;
        }else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] > m) {
                    continue;
                }
                list.add(nums[i]);
                backTracking(nums, list, i , m - nums[i], n);
                list.removeLast();
            }
        }

    }


    public static int numberofprize (int a, int b, int c) {
        // write code here
        int res = 0;
        int[] nums = new int[]{a,b,c};
        Arrays.sort(nums);
        res = nums[0];
        nums[1] = nums[1] - nums[0];
        nums[2] = nums[2] - nums[0];
        nums[0] = 0;
        res += nums[1]/2;
        nums[2] -= (nums[1]/2)*2;
        nums[1] = nums[1] % 2;
        if(nums[1] == 1 && nums[2] >= 3){
            nums[1] = 0;
            nums[2]-=3;
            res ++;

        }
        while (nums[2] > 5){
            nums[2] -= 5;
            res++;
        }
        return res;
    }
    public static int getHouses (int t, int[] xa) {
        // write code here
        int result = 2;
        List<List<Double>> res = new ArrayList<>();
//        int[][] res = new int[xa.length/2][2];
        for (int i = 0;i < xa.length;i+=2){
            List<Double> list = new ArrayList<>();
            list.add(((xa[i]*1.0-xa[i+1]/2.0)));
            list.add((xa[i]*1.0+xa[i+1]/2.0));
            res.add(list);
        }
        res.sort((o1, o2) -> (int) (o1.get(1)-o2.get(0)));
        for (int i = res.size()-1;i > 0;i--){
            if(res.get(i).get(0) - res.get(i-1).get(1)>t){
                result += 2;
            }else if (res.get(i).get(0) - res.get(i-1).get(1)==t){
                result += 1;
            }
        }
        return result;
    }
    public static int getIndex(int[] nums,int targer){
        int n = nums.length;
        int i = 0,j = n-1;
        while (i < j){
            int mid = (i+j)/2;
            if (nums[mid] > nums[j]){
                i = mid + 1;
            }if (nums[mid] < nums[j]){
                j = mid;
            }else {
                j--;
            }
        }
        return nums[i];
    }
    public static int setNumber(int n){
        n = n-1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n + 1;
    }
    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        int max1 = nums[0];
        for (int i = 1;i<nums.length;i++){
            if (max1 > nums[i]){
                max = Math.max(max1-nums[i],max);
            }else {
                max1 = nums[i];
            }
        }
        return max;
    }
    public static int[] quickSort(int[] nums,int start,int end){
        if (start > end) return nums;
        int i = start,j = end;
        int key = nums[start];
        while (i < j){
            while (i < j && nums[j]>=key){
                j--;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i]<key){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }

        }
        nums[i] = key;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
        return nums;
    }
    class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<Integer>();
            stack2 = new LinkedList<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            // 如果第二个栈为空
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                int deleteItem = stack2.pop();
                return deleteItem;
            }
        }
    }
    public static int[] xy(String s){
        if (s == null || s.length() < 1)return new int[]{0,0};
        int x = 0,y = 0;
        String[] split = s.split(";");
        for (String str : split){
            if (str == null || str.length()<1) continue;
            if (!(str.charAt(0)=='A'||str.charAt(0)=='D'||str.charAt(0)=='W'||str.charAt(0)=='S')){
                continue;
            }
            int m = 0;
            for (int i = 1;i < str.length();i++){
                if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                    m = 0;
                    break;
                }
                m = m*10 + str.charAt(i)-'0';

            }
            if (str.charAt(0) == 'A'){
                x = x-m;
            }
            if (str.charAt(0) == 'D'){
                x = x+m;
            }
            if (str.charAt(0) == 'W'){
                y = y+m;
            }
            if (str.charAt(0) == 'S'){
                y = y-m;
            }
        }
        return new int[]{x,y};
    }
    public static void isPassword(String s){
        if (s.length() <= 8) {
            System.out.println("NG");
            return;
        }
        // 寻找最长重复子串
        if (repeartLength(s)) {
            System.out.println("NG");
            return;
        }
        boolean up = false,low = false,other = false,number = false;
        for (int i = 0; i < s.length();i++){
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                if (number) continue;
                number = true;
            }else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
                if (low) continue;
                low = true;
            }else if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
                if (up) continue;
                up = true;
            }else {
                if (other) continue;
                other = true;
            }
        }
        if ((!up && low && number && other)||(up && !low && number && other)
                ||(up && low && !number && other)||(up && low && number && !other) || (up && low && number && other)){
            System.out.println("OK");
        }else {
            System.out.println("NG");
        }


    }
    public static boolean repeartLength(String s){
        Set<String> set =new HashSet<>();
        for (int i = 0;i < s.length();i++){
            String substring;
            if (i + 3 < s.length()) {
                substring = s.substring(i, i + 3);
            }else {
                substring = s.substring(i);
            }
            if (set.contains(substring)){
                return true;
            }else {
                set.add(substring);
            }
        }
        return false;
    }
    public static int thirdPrice(int[] nums){
        Arrays.sort(nums);
        int k = 1;
        int min = nums[0];
        int i = 1;
        while (i < nums.length && k < 3){
            if (nums[i] > min){
                min = nums[i];
                k++;
            }
            i++;
        }
        if (k == 3){
            return nums[i-1];
        }else {
            return -1;
        }
    }

}