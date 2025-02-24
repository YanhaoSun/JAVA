package 树.二叉树.遍历模式解决二叉树;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣144
 * easy
 */
public class BinaryTreePreorderTraversal {
    List<Integer> preOrder = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return preOrder;
    }
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        preOrder.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
