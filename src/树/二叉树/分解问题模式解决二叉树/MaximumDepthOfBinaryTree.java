package 树.二叉树.分解问题模式解决二叉树;

import BinaryTree.TreeNode;

/**
 * 力扣104
 * easy
 */
public class MaximumDepthOfBinaryTree {
    int res = 0;
    int nodeDepth = 0;
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
    public void traverse(TreeNode root){

    }

}
