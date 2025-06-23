package 线性表.链表.单链表的花式反转方法汇总;

import list.ListNode;

public class 反转链表前n个节点 {
    // 解法1, 迭代解法
    public static ListNode reverse1(ListNode head, int n){
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
//    public static ListNode reverse1_Prac(ListNode head, int n){
//    }
    //解法2, 递归解法
    static ListNode successor = null;
    public static ListNode reverse2(ListNode head, int n){
        if (n==1){
            successor = head.next;
            return head;
        }
        ListNode last = reverse2(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    static ListNode successor1 = null;
    public static ListNode reverse2_Prac(ListNode head, int n){
        if (n==1){
            successor1 = head.next;
            return head;
        }
        ListNode last = reverse2_Prac(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode res = reverse2(head, 3);
        while (res!=null){
            System.out.print("res = "+res.val+", ");
            res = res.next;
        }
    }
}
