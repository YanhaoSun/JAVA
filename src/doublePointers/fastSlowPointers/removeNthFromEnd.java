package doublePointers.fastSlowPointers;

import list.ListNode;

import java.util.List;

public class removeNthFromEnd {
    public static ListNode removeNthFromEndAlgo(ListNode listHead, int n) {
        if (listHead.next==null){
            return listHead;
        }
        ListNode fast = listHead;
        ListNode slow = listHead;
        int i = 0;
        while (fast.next!=null){
            fast = fast.next;
            if (i>n) {
                slow = slow.next;
            }
            i++;
        }
        if (i==n){
            return listHead.next;
        }
        slow.next = slow.next.next;
        return listHead;
    }
    public static ListNode removeNthFromEndAlgo1(ListNode listHead, int n) {
        ListNode fast = listHead;
        ListNode slow = listHead;
        int i = 0;
        while (fast.next!=null){
            fast = fast.next;
            if (i>n){
                slow = slow.next;
            }
            i++;
        }
        if (i==n){
            return listHead.next;
        }
        slow.next = slow.next.next;
        return listHead;
    }
    public static void main(String[] args) {
        ListNode head =  new ListNode(2);
        ListNode node1 =  new ListNode(3);
        ListNode node2 =  new ListNode(4);
        ListNode node3 =  new ListNode(5);
        ListNode node4 =  new ListNode(6);
        ListNode node5 =  new ListNode(7);
        head.next=node1;
        ListNode result = removeNthFromEndAlgo(head, 1);
        System.out.println("re = "+result.val);

        ListNode result1 = removeNthFromEndAlgo1(head, 1);
        System.out.println("re = "+result1.val);
    }
}
