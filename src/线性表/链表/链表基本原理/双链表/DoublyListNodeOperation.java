package 线性表.链表.链表基本原理.双链表;

import org.graalvm.compiler.graph.NodeInputList;

public class DoublyListNodeOperation {
    /**
     * 查/改
     * O(n)
     */
    public void queryDoublyListNode(int[] arr) {
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode tail = null;
        // 从前往后遍历
        for (DoublyListNode cur = head; cur != null; cur = cur.next){
            System.out.println(cur.val);
            tail = cur;
        }
        // 从后往前遍历
        for (DoublyListNode cur = tail; cur != null; cur = cur.prev){
            System.out.println(cur.val);
        }
    }

    /**
     * 在双链表头部添加新元素
     * O(1)
     */
    public DoublyListNode insertNodeToHead(int val, int[] arr) {
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode p = new DoublyListNode(val);
        p.next = head;
        head.prev = p;
        head = p;
        return head;
    }

    /**
     * 在双链表尾部插入元素
     * O(n)
     */
    public DoublyListNode insertNodeToRear(int val, int[] arr) {
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode tail = new DoublyListNode(val);
        DoublyListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = tail;
        tail.prev = cur;

        return head;
    }

    /**
     * 在双链表中间插入新元素
     * O(n)
     */
    public DoublyListNode insertNodeToMiddle(int pos, int val, int[] arr) {
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode cur = head;
        for (int i = 0; i<pos-2; i++){
            cur = cur.next;
        }
        DoublyListNode newNode = new DoublyListNode(val);
        newNode.next = cur.next;
        newNode.prev = cur;

        cur.next.prev = newNode;
        cur.next = newNode;

        return head;

    }

    /**
     * 在双链表中删除一个节点
     * O(n)
     */
    public DoublyListNode deleteNode(int pos, int[] arr){
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode cur = head;
        for (int i = 0; i < pos-2; i++){
            cur = cur.next;
        }
        DoublyListNode toDelete = cur.next;
        cur.next = toDelete.next;
        toDelete.next.prev = cur;

        toDelete.next = null;
        toDelete.prev = null;

        return head;
    }

    /**
     * 在双链表头部删除元素
     * O(1)
     */
    public DoublyListNode deleteHeadNode(int[] arr){
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode toDelete = head;

        head = head.next;
        head.prev = null;
        toDelete.next = null;
        toDelete.prev = null;

        return head;
    }

    /**
     * 在双链表尾部删除元素
     * O(n)
     */
    public DoublyListNode deleteRearNode(int[] arr){
        DoublyListNode head = Util.createDoublyLinkedList(arr);
        DoublyListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.prev.next = null;
        tail.prev = null;

        return head;
    }
}
