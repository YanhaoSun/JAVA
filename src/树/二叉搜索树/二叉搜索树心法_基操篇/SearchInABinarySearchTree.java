package 树.二叉搜索树.二叉搜索树心法_基操篇;

import BinaryTree.TreeNode;

/**
 * 力扣700
 * easy
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (val<root.val){
            return searchBST(root.left, val);
        } else if (val>root.val){
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
