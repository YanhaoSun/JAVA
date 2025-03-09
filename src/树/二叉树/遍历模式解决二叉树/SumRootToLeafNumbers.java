package 树.二叉树.遍历模式解决二叉树;
import BinaryTree.TreeNode;

import java.util.LinkedList;

/**
 * 力扣129
 * medium
 */
public class SumRootToLeafNumbers {
    StringBuilder path = new StringBuilder();
    LinkedList<Integer> result = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        traverse(root);
        if (!result.isEmpty()){
            for (Integer a: result){
                sum += a;
            }
        }
        return sum;
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        path.append(root.val);
        if (root.left==null && root.right==null){
            result.addLast(Integer.parseInt(path.toString()));
        }
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length()-1);
    }
}
