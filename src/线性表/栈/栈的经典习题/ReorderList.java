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
    public static void solution1(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p!=null){
            stack.push(p);
            p = p.next;
        }
        p = head;
        while (!stack.isEmpty()){
            ListNode lastNode = stack.pop();
            ListNode next = p.next;
            if (lastNode==p || lastNode==next){
                lastNode.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = next;
            p = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=  new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution1(head);
    }
}
