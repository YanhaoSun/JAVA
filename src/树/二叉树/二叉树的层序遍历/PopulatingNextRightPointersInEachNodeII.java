package 树.二叉树.二叉树的层序遍历;

import 线性表.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣117
 * medium
 */
public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
//        root.next = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                Node cur = queue.poll();
                if (pre!=null){
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            pre.next = null;
            pre = null;
        }
        return root;
    }
}
