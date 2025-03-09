package 树.二叉搜索树.二叉搜索树心法_特性篇;

import BinaryTree.TreeNode;

/**
 * 力扣230
 * medium
 */
public class KthSmallestElementInABST {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    public void traverse(TreeNode root, int k){
        if (root==null) return;
        traverse(root.left, k);
        count++;
        if (count==k){
            res = root.val;
        }
        traverse(root.right, k);
    }
}
