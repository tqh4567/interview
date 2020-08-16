package com.leecode.medium.linkedList;

import com.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class RemoveNthFromEnd19 {
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
