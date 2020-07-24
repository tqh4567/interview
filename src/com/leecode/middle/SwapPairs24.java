package com.leecode.middle;

public class SwapPairs24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // 两两交换链表中的节点
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode begin = head;
        ListNode end = null,pNext = null;
        while (begin != null){
            end = begin;
            for (int i = 1;i < 2;i++){
                if (end.next != null) {
                    end = end.next;
                }else {
                    return dummyNode.next;
                }
            }
            pNext = end.next;
            end.next = null;
            begin.next = null;
            pre.next = end;
            end.next = begin;
            begin.next = pNext;
            pre = begin;
            begin = pNext;
        }
        return dummyNode.next;
    }
    public static ListNode swapPairsFromM2N(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode begin = head;
        ListNode end = null,pNext = null;
        while (begin != null){
            end = begin;
            for (int i = 1;i < 2;i++){
                if (end.next != null) {
                    end = end.next;
                }else {
                    return dummyNode.next;
                }
            }
            pNext = end.next;
            end.next = null;
            begin.next = null;
            pre.next = end;
            end.next = begin;
            begin.next = pNext;
            pre = begin;
            begin = pNext;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = swapPairs(node);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
