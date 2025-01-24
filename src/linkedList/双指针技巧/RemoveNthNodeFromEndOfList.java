package linkedList.双指针技巧;

import list.ListNode;

import java.util.List;
/**
 * 力扣第 19 题「删除链表的倒数第 N 个结点」
 * Medium
*/
public class RemoveNthNodeFromEndOfList {
    public static ListNode solution(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = solutionHelper(dummy, n+1);
        x.next = x.next.next;
        return dummy.next;
    }
    public static ListNode solutionHelper(ListNode head, int n){
        ListNode p1 = head;
        for (int i=0; i<n; i++){
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static ListNode solution1(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode priorNode = solutionHelper1(dummy, n+1);
        priorNode.next = priorNode.next.next;
        return dummy.next;
    }
    public static ListNode solutionHelper1(ListNode head, int n){
        ListNode p1 = head;
        for (int i=0; i<n; i++){
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
