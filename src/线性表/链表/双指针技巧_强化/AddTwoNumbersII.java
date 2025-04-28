package 线性表.链表.双指针技巧_强化;

import list.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public static ListNode solution(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        while (l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode p;
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry>0){
            int val = carry;
            if (!s1.isEmpty()){
                val += s1.pop();
            }
            if (!s2.isEmpty()){
                val += s2.pop();
            }
            carry = val/10;
            val = val%10;

            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        for (int i=0; i<20; i++){
            if (i%1==0){
                System.out.println("hello");
            }
//            System.out.println(i%1);
        }
    }
}
