package 树.二叉树.分解问题模式解决二叉树;

import BinaryTree.TreeNode;

/**
 * 力扣543
 * easy
 */
public class DiameterOfBinaryTree {
    int maxDiameter = 0;

    /**
     * 该算法的复杂度太高: O(n^2)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, (maxLeftDepth+maxRightDepth));

        traverse(root.left);
        traverse(root.right);
    }
    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight)+1;
    }

    /**
     * 更好的解法
     */
    public int diameterOfBinaryTree1(TreeNode root) {
        maxDepth1(root);
        return maxDiameter;
    }
    public int maxDepth1(TreeNode root){
        if (root==null){
            return 0;
        }
        int maxLeft = maxDepth1(root.left);
        int maxRight = maxDepth1(root.right);
        maxDiameter = Math.max(maxDiameter, (maxLeft+maxRight));
        return Math.max(maxLeft, maxRight)+1;
    }
}