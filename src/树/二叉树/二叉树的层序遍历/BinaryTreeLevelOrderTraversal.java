package 树.二叉树.二叉树的层序遍历;
import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣102
 * medium
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> treeLevel = new LinkedList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                treeLevel.add(node.val);
            }
            result.add(treeLevel);
        }
        return result;
    }
}
