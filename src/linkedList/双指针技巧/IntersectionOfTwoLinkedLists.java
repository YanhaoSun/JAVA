package linkedList.双指针技巧;

import list.ListNode;

import java.util.List;

/**
 * 力扣第 160 题「相交链表」
 * Easy 难度
 */
public class IntersectionOfTwoLinkedLists {
    public static ListNode solution(ListNode headA, ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=p2){
            if (p1==null){
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2==null){
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
    public static ListNode solution1(ListNode headA, ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=p2){
            if (p1==null){
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2==null){
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
