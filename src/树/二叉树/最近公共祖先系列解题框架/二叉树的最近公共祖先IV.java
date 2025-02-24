package 树.二叉树.最近公共祖先系列解题框架;

import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.HashSet;

/**
 * 力扣1676
 * medium
 */
public class 二叉树的最近公共祖先IV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes){
        HashSet<TreeNode> hashSet = new HashSet<>();
        for (TreeNode treeNode: nodes){
            hashSet.add(treeNode);
        }
        return find(root, hashSet);
    }
    public TreeNode find(TreeNode root, HashSet<TreeNode> hashSet){
        if (root==null) return null;
        if (hashSet.contains(root)){
            return root;
        }
        TreeNode left = find(root.left, hashSet);
        TreeNode right = find(root.right, hashSet);
        if (left!=null && right!=null){
            return root;
        }
        return left!=null? left:right;
    }
    /**
     * 优化
     */
    TreeNode LCA = null;
    public TreeNode find_opt(TreeNode root, HashSet<TreeNode> hashSet){
        if (root==null) return null;
        if (LCA!=null) return null;
        if (hashSet.contains(root)){
            return root;
        }
        TreeNode left = find(root.left, hashSet);
        TreeNode right = find(root.right, hashSet);
        if (left!=null && right!=null){
            LCA = root;
            return root;
        }
        return left!=null? left:right;
    }
}