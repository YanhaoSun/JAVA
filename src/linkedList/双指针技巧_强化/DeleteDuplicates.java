package linkedList.双指针技巧_强化;

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
    public static ListNode solution2(ListNode head){
        ListNode dummy = new ListNode(-1);
        return dummy;
    }
}
