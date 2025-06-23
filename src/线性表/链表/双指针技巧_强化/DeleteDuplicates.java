package 线性表.链表.双指针技巧_强化;

import list.ListNode;

import java.util.List;

/**
 * 力扣第 82 题「删除排序链表中的重复元素 II」
 * medium 难度
 */
public class DeleteDuplicates {
    /**
     * 分解链表解法
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){
        ListNode dummyUni = new ListNode(101);
        ListNode dummyDup = new ListNode(101);
        ListNode pUni, pDup, p;
        pUni = dummyUni;
        pDup = dummyDup;
        p = head;
        while (p!=null){
            if ((p.next!=null && p.val==p.next.val) || p.val==pDup.val){
                pDup.next = p;
                pDup = pDup.next;
            } else {
                pUni.next = p;
                pUni = pUni.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        return dummyUni.next;
    }
    public static ListNode solutionPra(ListNode head){
        ListNode dummyUni = new ListNode(101);
        ListNode dummyDup = new ListNode(101);
        ListNode pUni, pDup, p;
        pUni = dummyUni;
        pDup = dummyDup;
        p = head;
        while (p!=null){
            if ((p.next!=null && p.val==p.next.val) || p.val==pDup.val){
                pDup.next = p;
                pDup = pDup.next;
            } else {
                pUni.next = p;
                pUni = pUni.next;
            }
            p = p.next;
            pDup.next = null;
            pUni.next = null;
        }
        return dummyUni.next;
    }

    /**
     * 解法二 快慢双指针解法
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode p1, p;
        p1 = dummy;
        p = head;
        while (p!=null){
            if (p.next!=null && p.val==p.next.val){
                p = p.next;
                while (p.next!=null && p.val==p.next.val){
                    p = p.next;
                }
                p = p.next;
            } else {
                p1.next = p;
                p1 = p1.next;
                p = p.next;
            }
        }
        // 因为如果不把p1.next变成null的话, p1就是指向p后面的所有nodes, 没有进行截断
        // 比如说 1 2 3 3 4 4 5 6 6 6, 如果不截断, p1就会变成: 1 2 5 6 6 6,
        // 截断后就是: 1 2 5 null
        p1.next = null;
        return dummy.next;
    }
    public static ListNode solution1Pra(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode p1, p;
        p1 = dummy;
        p = head;
        while (p!=null){
            if (p.next!=null && p.val==p.next.val){
                p = p.next;
                while (p.next!=null && p.val==p.next.val){
                    p = p.next;
                }
                p = p.next;
                if (p==null){
                    p1.next = null;
                }
            } else {
                p1.next = p;
                p1 = p1.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
    /**
     * 解法三 递归解法
     * @param head
     * @return
     */
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    public static ListNode deleteDuplicates(ListNode head){
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicates(head.next);
            return head;
        }
        // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        // 越过重复节点，找到 head 之后那个不重复的节点
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return deleteDuplicates(head.next);
    }

    public static void main(String[] args) {
        int[][] ma = new int[10][10];
        int a = ma.length;
    }
}
