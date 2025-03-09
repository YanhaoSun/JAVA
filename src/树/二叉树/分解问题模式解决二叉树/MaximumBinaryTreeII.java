package 树.二叉树.分解问题模式解决二叉树;
import BinaryTree.TreeNode;
/**
 * 力扣998
 * medium
 */
public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val<val){
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }
}
