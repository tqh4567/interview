package com.leecode.middle;

import com.sun.deploy.security.CredentialManager;

public class RemoveNthFromEnd19 {
    // 静态内部类，定义链表节点类型
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;
        ListNode cur = node;
        for (int i = 0 ;i < n;i ++){
            temp = temp.next;
        }
        while (temp.next != null){
            temp = temp.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
//        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = removeNthFromEnd(new ListNode(2), 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
