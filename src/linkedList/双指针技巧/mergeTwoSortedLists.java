package linkedList.双指针技巧;

import list.ListNode;

/**
 * 力扣第 21 题「合并两个有序链表
 * Easy
 */
public class mergeTwoSortedLists {
    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1!=null && p2!=null){
            if (p1.val>p2.val){
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
//        while (p1!=null){
//            p.next = p1;
//            p1 = p1.next;
//            p = p.next;
//        }
//        while (p2!=null){
//            p.next = p2;
//            p2 = p2.next;
//            p = p.next;
//        }

         if (p1 != null) {
             p.next = p1;
         }

         if (p2 != null) {
             p.next = p2;
         }
        return dummy.next;
    }
    public static ListNode solutionPractice(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p1, p2, p;
        p1 = l1;
        p2 = l2;
        p = dummy;
        while (p1!=null && p2!=null){
            if (p1.val<= p2.val){
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1==null){
            p.next = p2;
        }
        if (p2==null){
            p.next = p1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(7);

        ListNode result = solutionPractice(l1, l2);
        while (result!=null){
            System.out.println(result.val+", ");
            result = result.next;
        }
    }
}
