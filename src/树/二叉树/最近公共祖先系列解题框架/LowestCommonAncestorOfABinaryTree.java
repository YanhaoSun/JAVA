package 树.二叉树.最近公共祖先系列解题框架;
import BinaryTree.TreeNode;
/**
 * 力扣236
 * medium
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)return null;
        if (root==p || root==q){
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left!=null && right!=null){
            return root;
        }
        return left!=null? left:right;
    }

    /**
     * 优化
     */
    TreeNode commonAnce = null;
    public TreeNode find_opt(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)return null;
        if (commonAnce!=null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left!=null && right!=null){
            commonAnce = root;
            return root;
        }
        return left!=null? left:right;
    }
}
