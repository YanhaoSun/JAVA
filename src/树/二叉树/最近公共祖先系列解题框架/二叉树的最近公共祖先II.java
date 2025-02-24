package 树.二叉树.最近公共祖先系列解题框架;

import BinaryTree.TreeNode;

/**
 * 力扣1644
 * medium
 */
public class 二叉树的最近公共祖先II {
    boolean foundP = false;
    boolean foundQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = find(root, p, q);
        if (foundP && foundQ){
            return LCA;
        }
        return null;
    }
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return null;

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left!=null && right!=null){
            return root;
        }
        if (root==p || root==q){
            if (root==p) foundP = true;
            if (root==q) foundQ = true;
            return root;
        }
        return left!=null? left:right;
    }
}
