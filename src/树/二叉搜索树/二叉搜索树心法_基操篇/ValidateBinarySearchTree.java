package 树.二叉搜索树.二叉搜索树心法_基操篇;
import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * 力扣98
 * medium
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }
    public boolean traverse(TreeNode root, TreeNode min, TreeNode max){
        if (root==null) return true;
        if (min!=null && root.val<=min.val) return false;
        if (max!=null && root.val>=max.val) return false;
        return traverse(root.left, min, root) && traverse(root.right, root, max);
    }
    public static void main(String[] args) {
        boolean left = false;
        boolean right = false;
        System.out.println(left && right);
    }
}
