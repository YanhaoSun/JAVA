package 树.二叉树.分解问题模式解决二叉树;

import BinaryTree.TreeNode;

/**
 * 力扣226
 * easy
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;
        return root;
    }
}
