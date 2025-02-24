package 树.二叉树.最近公共祖先系列解题框架;

import BinaryTree.TreeNode;

/**
 * 力扣235
 * medium
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int big = Math.max(p.val, q.val);
        return find(root, small, big);
    }
    public TreeNode find(TreeNode root, int small, int big){
        if (root==null) return null;
        if (root.val<small){
            return find(root.right, small, big);
        }
        if (root.val>big){
            return find(root.left, small, big);
        }
        return root;
    }
}
