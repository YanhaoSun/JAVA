package list;

import java.util.List;

public class removeListElement {
    // 方法一
    public ListNode removeElements_one(ListNode head, int val){
          while (head != null && head.val==val){
              head = head.next;
          }
          if (head == null){
              return head;
          }

          ListNode pre = head;
          ListNode cur = head.next;
          while (cur!=null){
              if (cur.val==val){
                  pre.next=cur.next;
              } else {
                  pre = cur;
              }
              cur = cur.next;
          }
          return head;
      }
    // 方法二: 使用虚拟节点可以省略单独检查head的步骤, 使代码更加简洁
    public ListNode removeElements_Two(ListNode head, int val){
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next!=null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}