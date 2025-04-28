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
    public TreeNode insertIntoMaxTree2(TreeNode root, int val){
        if (root==null){
            return new TreeNode(val);
        }
        if (root.val<val){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        TreeNode right = insertIntoMaxTree(root.right, val);
        /**
         * 这里之所以将root.left注释掉是因为:
         *      root的左子树是不变的, 如果不注释掉,
         *          (1)-就会进入左子树将newVal与左子树的节点进行比较从而在左子树中创建出多余的newVal节点
         *          (2)-当root==null时, 叶子结点的左子树本来应该是null, 但是因为进入了左子树,
         *              左子树就会创建newVal节点, 左子树就不是null了, 就把树改变了
         */
        // TreeNode left = insertIntoMaxTree(root.left, val);
        // root.left = left;
        root.right = right;
        return root;
    }
}
