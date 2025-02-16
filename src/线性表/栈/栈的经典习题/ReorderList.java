package 线性表.栈.栈的经典习题;

import list.ListNode;

import java.util.Stack;

/**
 * 力扣143
 * medium
 */
public class ReorderList {
    public void solution(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode p = head;
        while (p!=null){
            stk.push(p);
            p = p.next;
        }
        p = head;
        while (p!=null){
            ListNode lastNode = stk.pop();
            ListNode next = p.next;
            if (lastNode==next || lastNode.next==next){
                lastNode.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = next;
            p = next;
        }
    }
}
