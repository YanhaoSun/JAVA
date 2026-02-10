package 线性表.链表.链表基本原理.单链表;

public class ListNodeOperation {
    /**
     * 查/改
     * O(n)
     */
    public void queryLinkedListNode(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    /**
     * 在单链表头部添加新元素
     * O(1)
     */
    public ListNode insertNodeToHead(int val, ListNode head) {
        ListNode cur = new ListNode(val);
        cur.next = head;
        head = cur;
        return head;
    }

    /**
     * 在单链表尾部加入新元素
     * O(n)
     */
    public ListNode insertNodeToRear(int val, ListNode head) {
        ListNode cur = head;
        while (cur.next!=null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        return head;
    }

    /**
     * 在单链表中间插入新元素(在第pos个元素的后面插入新元素)
     * O(n)
     */
    public ListNode insertNodeToMiddle(int val, int pos, ListNode head){
        ListNode cur = head;
        for (int i = 0; i < pos-1; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }

    /**
     * 在单链表中删除第pos个节点
     * O(n)
     */
    public ListNode deleteNode(int pos, ListNode head){
        if (head == null){
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < pos-2; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    /**
     * 在单链表尾部删除元素
     * O(n)
     */
    public ListNode deleteRearNode(ListNode head){
        ListNode cur = head;
        while (cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    /**
     * 在单链表头部删除元素
     * O(1)
     */
    public ListNode deleteHeadNode(ListNode head){
        return head.next;
    }
    ListNode head1 = NodeUtil.createLinkedList(new int[]{1, 2, 3, 4, 5});
    public static void main(String[] args) {

    }

}
