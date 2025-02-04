package linkedList.双指针技巧;

import list.ListNode;

/**
 * 力扣83
 * easy
 */
public class deleteDuplicates {
    public static ListNode solution(ListNode head){
        ListNode fast, slow;
        fast = head;
        slow = head;
        if (head==null){
            return null;
        }
        while (fast!=null){
            if (fast.val!=slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
