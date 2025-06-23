package 线性表.链表.单链表的花式反转方法汇总;

import list.ListNode;

/**
 * 力扣25
 * medium
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i=0; i<k; i++){
            if (b==null) return head;
            b = b.next;
        }
        a = reverseNIterate(a, k);
        b = reverseKGroup(b, k);
        head.next = b;
        return a;
    }
    public ListNode reverseNIterate(ListNode head, int n){
        ListNode pre = null;
        ListNode cur = head;
        while (n>0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        head.next = cur;
        return pre;
    }
    ListNode successor = null;
    public ListNode reverseNRecursive(ListNode head, int n){
        if (n==1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseNRecursive(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
