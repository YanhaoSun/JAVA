package 线性表.链表.双指针技巧;

import list.ListNode;

import java.util.List;

/**
 * 力扣第 876 题「链表的中间结点
 * Easy
 */
public class MiddleOfTheLinkedList {
    public static ListNode solution(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (fast!=null){
            if (count!=0 && count%2==0){
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        if (count!=0 && count%2==0){
            return slow.next;
        } else {
            return slow;
        }
    }
    public static ListNode solution1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode smarterSolution(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
