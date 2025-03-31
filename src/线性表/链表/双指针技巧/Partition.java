package 线性表.链表.双指针技巧;

import list.ListNode;

import java.util.List;

/**
 * 力扣第 86 题「分隔链表」
 * Medium
 */
public class Partition {
    public static ListNode solution(ListNode head, int x){
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1, p2;
        p1 = dummy1;
        p2 = dummy2;
        ListNode p = head;
        while (p!=null){
            if (p.val>=x){
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
    public static ListNode solution1(ListNode head, int x){
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1, p2, p;
        p1 = dummy1;
        p2 = dummy2;
        p = head;
        while (p!=null){
            if (p.val<x){
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = solution1(head, 3);
        while(result!=null){
            System.out.println(result.val+", ");
            result = result.next;
        }
    }
}
