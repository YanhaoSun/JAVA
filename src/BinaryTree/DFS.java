package BinaryTree;

public class DFS {
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
