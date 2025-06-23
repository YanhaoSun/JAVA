package 线性表.链表.判断回文链表;
import list.ListNode;
/**
 * 力扣234
 * easy
 */
public class PalindromeLinkedList {
    // 解法1: 后续递归解法
    ListNode left, right;
    boolean res = true;
    public boolean isPalindrome(ListNode head) {
        if (head==null){
            return false;
        }
        left = head;
        traverse(left);
        return res;
    }
    public void traverse(ListNode right){
        if (right==null){
            return;
        }
        traverse(right.next);
        if (left.val!=right.val){
            res = false;
        }
        left = left.next;
    }
    // 解法2: 寻找中点并进行链表反转解法
}
