package linkedList.双指针技巧;

import list.ListNode;

/**
 * 142. Linked List Cycle II
 * Medium
 */
public class LinkedListCycleII {
    public static ListNode solution(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow){
                break;
            }
        }
        if (fast==null || fast.next==null){
            return null;
        }
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static ListNode solution1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                break;
            }
        }
        if (fast==null || fast.next==null){
            return null;
        }
        slow = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
