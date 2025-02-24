package 树.二叉树.分解问题模式解决二叉树;

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
        List<Integer> temp = new ArrayList<>();
        if (root==null){
            return temp;
        }
        int val = root.val;
        temp.add(val);
        temp.addAll(preorderTraversal(root.left));
        temp.addAll(preorderTraversal(root.right));
        return temp;
    }
}
