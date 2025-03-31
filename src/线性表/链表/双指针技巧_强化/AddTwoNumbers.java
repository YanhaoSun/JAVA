package 线性表.linkedList.双指针技巧_强化;


import list.ListNode;

/**
 * 力扣 2
 * medium
 */
public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p1, p2, p;
        p1 = l1;
        p2 = l2;
        p = dummy;
        int carry = 0;
        while (p1!=null || p2!=null || carry>0){
            int val = carry;
            if (p1!=null){
                val += p1.val;
                p1 = p1.next;
            }
            if (p2!=null){
                val += p2.val;
                p2 = p2.next;
            }
            carry = val/10;
            val = val%10;
            p.next = new ListNode(val);
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int x = 22/10;
        System.out.println("22/10 = "+x);
    }
}
