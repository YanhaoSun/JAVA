package 树.二叉搜索树.二叉搜索树心法_基操篇;
import BinaryTree.TreeNode;
/**
 * 力扣701
 * medium
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);
        if (root.val<val){
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val>val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}