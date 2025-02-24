package 树.二叉树.最近公共祖先系列解题框架;

import list.ListNode;
import 线性表.Node;

/**
 * 力扣1650
 * medium
 */
public class 二叉树的最近公共祖先III {
    public Node lowestCommonAncestor(Node p, Node q){
        Node a = p;
        Node b = q;
        while (a!=b){
            if (a==null) a = q;
            else a = a.parent;

            if (b==null) b = p;
            else b = b.parent;
        }
        return a;
    }
}
