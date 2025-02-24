package 树.二叉树.遍历模式解决二叉树;
import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * 力扣226
 * easy
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        traverse(root.left);
        traverse(root.right);
    }
}
