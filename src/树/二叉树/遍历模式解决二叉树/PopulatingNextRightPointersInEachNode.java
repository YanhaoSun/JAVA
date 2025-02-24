package 树.二叉树.遍历模式解决二叉树;

import BinaryTree.Node;

/**
 * 力扣116
 * medium
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root==null) return null;
        traverse(root.left, root.right);
        return root;
    }
    public void traverse(Node node1, Node node2){
        if (node1==null && node2==null){
            return;
        }
        node1.next = node2;
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }
}
