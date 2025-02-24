package 树.二叉树.遍历模式解决二叉树;

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

    public int maxDepth_Prac(TreeNode root) {
        traverse_Prac(root);
        return res;
    }
    public void traverse_Prac(TreeNode root){
        if (root==null){
            return;
        }
        nodeDepth++;
        if (res<nodeDepth){
            res = nodeDepth;
        }
        traverse_Prac(root.left);
        traverse_Prac(root.right);
        nodeDepth--;
    }
}
