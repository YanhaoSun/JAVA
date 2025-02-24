package 树.二叉树.如何计算完全二叉树的节点数;
import BinaryTree.TreeNode;
/**
 * 力扣222
 * easy
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int hl = 0;
        int hr = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left!=null){
            hl++;
            left = left.left;
        }
        while (right!=null){
            hr++;
            right = right.right;
        }
        if (hl==hr){
            return (int)Math.pow(2, hr)-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
