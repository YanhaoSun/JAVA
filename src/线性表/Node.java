package 线性表;

import list.ListNode;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
    public Node() {}
    public Node(int val) { this.val = val; }
    public Node(int val, Node left, Node right, Node parent) {
        this.val = val;
        this.right = right;
        this.left = left;
        this.parent = parent;
    }
};
