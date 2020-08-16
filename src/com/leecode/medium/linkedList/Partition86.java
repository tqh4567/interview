package com.leecode.medium.linkedList;

import com.utils.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 */
public class Partition86 {
    public static ListNode partition(ListNode head, int x) {
        /*
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head;
        ListNode pre1 = head;
        while (cur != null && cur.val != x){
            cur = cur.next;
        }
        while (pre1.next != null && pre1.next.val != x){
            pre1 = pre1.next;
        }
        ListNode mid = cur;
        ListNode midPre = pre1;
        while (pre != null && pre != mid){
            if (pre.val > x){
                ListNode node = new ListNode(pre.val);
                ListNode temp = cur.next;
                cur.next = node;
                node.next = temp;
                cur = cur.next;

            }
            pre = pre.next;
        }
        while (cur != null){
            if (cur.val < x){
                ListNode node = new ListNode(cur.val);
                midPre.next = node;node.next = mid;
                midPre = midPre.next;
            }
            cur = cur.next;

        }
        ListNode node = head;
        ListNode delete =head.next;
        while (delete != mid){
            if (delete.val > x){
                node.next = delete.next;
            }
            node = node.next;
            delete = delete.next;
        }
        while (mid != null){
            if (mid.val < x){
                midPre.next = mid.next;
            }
            mid = mid.next;
            midPre = midPre.next;
        }
         */
        // 需要创建哑节点与新的链表
        if (head == null ) return null;
        if (head.next == null ) return head;
        ListNode node1 = new ListNode(0);
        ListNode temp1 = node1;
        ListNode node2 = new ListNode(0);
        ListNode temp2 = node2;
        while (head != null){
            if (head.val < x){
                temp1.next = new ListNode(head.val);
                temp1.next = head;
                temp1 = temp1.next;
            }else {
//                temp2.next = new ListNode(cur.val);
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        // 必须将链表2结尾置空，让其结束
        temp2.next = null;
        temp1.next = node2.next;
        return  node1.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;

        before.next = after_head.next;

        return before_head.next;
        }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        node4.next =node5;
        node3.next =node4;
        node2.next =node3;
        node1.next =node2;
        node.next =node1;
        ListNode head = partition(node, 3);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
