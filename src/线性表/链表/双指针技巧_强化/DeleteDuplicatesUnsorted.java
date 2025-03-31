package 线性表.linkedList.双指针技巧_强化;

import list.ListNode;

import java.util.HashMap;

/**
 * 力扣第 1836 题「从未排序的链表中移除重复元素」
 * medium 难度
 */
public class DeleteDuplicatesUnsorted {
    /**
     * 链表分解解法
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){
        ListNode p = head;
        HashMap<Integer, Integer> count = new HashMap<>();
        while (p!=null){
            count.put(p.val, count.getOrDefault(p.val, 0)+1);
            p = p.next;
        }
        ListNode dummyUni = new ListNode(-1);
        ListNode dummyDup = new ListNode(-1);
        ListNode pUni, pDup;
        pUni = dummyUni;
        pDup = dummyDup;
        p = head;
        while (p!=null){
            if (count.get(p.val)>1){
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
    public static ListNode solutionPra(ListNode head){
        HashMap<Integer, Integer> count = new HashMap<>();
        ListNode p = head;
        while (p!=null){
            count.put(p.val, count.getOrDefault(p.val, 0)+1);
            p = p.next;
        }
        ListNode dummyUni = new ListNode(-1);
        ListNode dummyDup = new ListNode(-1);
        ListNode pUni, pDup;
        pUni = dummyUni;
        pDup = dummyDup;
        p = head;
        while (p!=null){
            if (count.get(p.val)>1){
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
}
