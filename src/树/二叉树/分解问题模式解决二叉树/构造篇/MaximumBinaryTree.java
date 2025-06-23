package 树.二叉树.分解问题模式解决二叉树.构造篇;

import BinaryTree.TreeNode;

/**
 * 力扣654
 * medium
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
    public TreeNode build(int[] nums, int lo, int hi){
        if (lo>hi){
            return null;
        }
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i=lo; i<=hi; i++){
            if (nums[i]>maxVal){
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        TreeNode left = build(nums, lo, index-1);
        TreeNode right = build(nums, index+1, hi);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

    }
}
