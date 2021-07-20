package com.leecode.medium.linkedList;

import com.utils.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class ReverseBetween92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode node = reverseBetween(head, 1, 2);
        while (node != null){
            System.out.println("reverseBetween(head,1,2) = " + node.val);
            node = node.next;
        }

    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre1 = dummy, start = head, end = head;
        for (int i = 1; i < m; i++) {
            pre1 = pre1.next;
            start = start.next;
        }
        for (int i = 1; i < n; i++) {
            end = end.next;
        }
        if (start == head){
            ListNode temp = end.next;
            end.next = null;
            reserveList(start);
            start.next = temp;
            return end;
        }
        if (end.next == null){
            reserveList(start);
            pre1.next = end;
            return head;
        }
        ListNode temp = end.next;
        end.next = null;
        reserveList(start);
        pre1.next = end;
        start.next = temp;
        return head;

    }

    public static ListNode reserveList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
