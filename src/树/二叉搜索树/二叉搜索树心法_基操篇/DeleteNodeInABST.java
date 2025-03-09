package 树.二叉搜索树.二叉搜索树心法_基操篇;
import BinaryTree.TreeNode;
/**
 * 力扣450
 * medium
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;
        if (root.val==key){
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        if (root.val>key){
            root.left = deleteNode(root.left, key);
        }
        if (root.val<key){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    public TreeNode getMin(TreeNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}