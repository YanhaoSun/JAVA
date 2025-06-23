package 线性表.链表.双指针技巧;

import list.ListNode;

import java.util.PriorityQueue;

/**
 * 力扣第 23 题「合并K个升序链表」
 * Hard
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        if (lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val-b.val));
        for (ListNode node: lists){
            if (node==null){
                pq.add(node);
            }
        }
        while (!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if (p.next!=null){
                pq.add(p.next);
            }
        }
        return dummy.next;
    }
}
