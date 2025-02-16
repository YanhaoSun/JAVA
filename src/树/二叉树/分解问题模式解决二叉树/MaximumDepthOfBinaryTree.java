package 树.二叉树.分解问题模式解决二叉树;

import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * 力扣104
 * easy
 */
public class MaximumDepthOfBinaryTree {
    int res = 0;
    int nodeDepth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        nodeDepth++;
        if (root.left==null && root.right==null){
            res = Math.max(res, nodeDepth);
        }
        traverse(root.left);
        traverse(root.right);
        nodeDepth--;
    }
}
