package 线性表.链表.单链表的花式反转方法汇总;

import list.ListNode;

/**
 * 力扣206
 * easy
 */
public class ReverseLinkedList {
    // 解法1
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    // 解法2
    public ListNode reverseList2(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
