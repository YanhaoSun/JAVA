package array.双指针技巧.左右指针.反转数组.顺逆时针旋转矩阵;

import list.ListNode;


/**
 * 力扣61
 * medium
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        int size = size(head);
        if (k==0 || k%size==0) return head;
        if (k>size) {
            k = k%size;
        }
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        ListNode tail;
        int step = 0;
        while (p1.next!=null){
            p1 = p1.next;
            step++;
            if (step>k){
                p2 = p2.next;
            }
        }
        tail = p1;
        ListNode temp = head;
        head = p2.next;
        p2.next = null;
        tail.next = temp;
        return head;
    }
    public static int size(ListNode head){
        int length = 0;
        while (head!=null){
            head = head.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        ListNode result = rotateRight(head, 2);
//        while(result!=null){
//            System.out.println(result.val);
//            result = result.next;
//        }

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode result = rotateRight(head, 4);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }

//        System.out.println(99%1);
    }
}
