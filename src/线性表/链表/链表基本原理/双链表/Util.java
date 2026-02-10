package 线性表.链表.链表基本原理.双链表;

public class Util {
    static public DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0){
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        for (int i = 1; i < arr.length; i++){
            DoublyListNode temp = new DoublyListNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
