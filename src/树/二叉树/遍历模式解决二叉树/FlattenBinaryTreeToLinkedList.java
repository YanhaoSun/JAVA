package 树.二叉树.遍历模式解决二叉树;

import BinaryTree.TreeNode;

/**
 * 力扣114
 * medium
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right!=null){
            p = p.right;
        }
        p.right = right;
    }
}
