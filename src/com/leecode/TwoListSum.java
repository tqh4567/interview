package com.leecode;

import java.util.*;

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class TwoListSum {
    public static void main(String[] args) {
        int[] ints = {6,6,3,2};
        System.out.println("args = " + maxProfit(ints));
    }
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) return new int[0];
        if(shorter == longer) return new int[]{k*shorter};
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i <= k;i++){
            int sum = i*longer + (k-i)*shorter;
            if(set.contains(sum)){
                continue;
            }
            set.add(sum);
            list.add(sum);
        }
        int[] result = new int[list.size()];
        for(int j = 0;j < list.size();j++){
            result[j] = list.get(j);
        }
        return result;
    }
    /**
     * 买卖股票获取最大收益(On2)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i =0;i<prices.length;i++){
            int rightmax = 0;
            for(int j = i+1;j<prices.length;j++){
                if(prices[j] >rightmax){
                    rightmax = prices[j];
                }
            }
            if(max < rightmax-prices[i]){
                max = rightmax - prices[i];
            }
        }
        return max;
    }
    /**
     * 买卖股票获取最大收益(On)
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i =0;i<prices.length;i++){
            if(min > prices[i]){
                min = prices[i];
            }
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }

    /**
     * 查找唯二出现一次的整数
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }
        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
//    public static int[] singleNumbers(int[] nums) {
//        int[] result = new int[2];
//        int count = 0;
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0;i < nums.length;i ++){
//            if (map.containsKey(nums[i])){
//                map.put(nums[i],map.get(nums[i])-1);
//            }else {
//                map.put(nums[i],1);
//            }
//        }
//        for (Integer integer : map.keySet()){
//            if (map.get(integer) != 0){
//                result[count++] = integer;
//            }
//        }
//        return result;
//    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;int j=i+2;
        int l = 0;
        int[] result = new int[nums.length-2];
        while(j < nums.length){
            int max = nums[i];
            int m = i;
            while(m<= j){
                if(nums[m]>max){
                    max = nums[m];
                }
                m++;
            }
            result[l++] = max;
            i++;
            j++;
        }
        return result;
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] copyOf = Arrays.copyOf(arr, k);

        return copyOf;
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if (set.contains(current.val)){
                ListNode temp = current.next;
                current.next = temp.next;
                current = temp.next;
            }
            else {
                set.add(current.val);
                current = current.next;
            }
        }
        return head;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode node = new ListNode(0);
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                node.next =l2;
                l2 = l2.next;
            }else{
                node.next = l1;
                l1 = l1.next;
            }
        }
        while(l1 != null){
            node.next = l1;
            l1 = l1.next;
        }
        while(l2 != null){
            node.next = l2;
            l2 = l2.next;
        }
        return node.next;
    }
    public static double myPow(double x, int n) {
        double result = 1d;
        if (n > 0){
            for(int i = 0;i < n;i++){
                result*=x;
            }
        }
        if (n < 0){
            for(int j = 0;j > n;j--){
                result/=x;
            }
        }
        return result;
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while(n>0){
            if((n&1)==1){
                count ++;
                n=n>>1;
            }
        }
        return count;
    }
    /**
     * 反转链表
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null){
            length++;
            current = current.next;
        }
        int [] result = new int[length];
        ListNode temp = head;
        while (temp != null){
            result [length--] = temp.val;
            temp = temp.next;
        }
        return result;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode result=new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while(l1 != null&&l2 != null){
            int sunNumber = (l1.val+l2.val+carry)%10;
            carry =(l1.val+l2.val+carry)/10;
            ListNode newNode = new ListNode(sunNumber);
            current.next=newNode;
            current = current.next;
            l1=l1.next;
            l2=l2.next;

        }
        while(l1 != null){
            carry=(l1.val+carry)/10;
            int sunNumber1 = (l1.val+carry)%10;
            ListNode newNode = new ListNode(sunNumber1);
            current.next=newNode;
            current = current.next;
            l1=l1.next;

        }
        while(l2 != null){
            carry=(l2.val+carry)/10;
            int sunNumber2 = (l2.val+carry)%10;
            ListNode newNode = new ListNode(sunNumber2);
            current.next=newNode;
            current = current.next;
            l2=l2.next;
        }
        if(carry!=0) current.next=new  ListNode(carry);
        return result.next;
    }
}
