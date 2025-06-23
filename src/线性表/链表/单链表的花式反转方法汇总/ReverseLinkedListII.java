package 线性表.链表.单链表的花式反转方法汇总;

import list.ListNode;

/**
 * 力扣92
 * medium
 */
public class ReverseLinkedListII {
    // 解法1, 迭代解法
    public ListNode reverseBetween1(ListNode head, int left, int right){
        if (left==1){
            return reverseNListNode(head, right-left+1);
        }
        ListNode preHead = head;
        for (int i=1; i<left-1; i++){
            preHead = preHead.next;
        }
        // 找到left的前一个节点, 然后应用 反转前N个节点 的解法
        preHead.next = reverseNListNode(preHead.next, right-left+1);
        return head;
    }
    public ListNode reverseNListNode(ListNode head, int n){
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

    // 解法2: 递归解法
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left==1){
            return reverse(head, left-right+1);
        }
        int n = 1;
        ListNode preHead = head;
        while (n<left-1){
            preHead = preHead.next;
            n++;
        }
        // 找到left的前一个节点, 然后应用 反转前N个节点 的解法
        preHead.next = reverse(preHead.next, right-left+1);
        return head;
    }
    ListNode successor = null;
    public ListNode reverse(ListNode head, int n){
        if (n==1){
            successor = head.next;
            return head;
        }
        ListNode last = reverse(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}