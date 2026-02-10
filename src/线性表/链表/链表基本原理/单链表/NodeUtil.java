package 线性表.链表.链表基本原理.单链表;

public class NodeUtil {
    static public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
}
