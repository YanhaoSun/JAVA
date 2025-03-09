package 树.二叉搜索树.二叉搜索树心法_特性篇;
import BinaryTree.TreeNode;
/**
 * 力扣538
 * medium
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
