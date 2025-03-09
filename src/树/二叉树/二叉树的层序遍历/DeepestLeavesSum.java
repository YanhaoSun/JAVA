package 树.二叉树.二叉树的层序遍历;
import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣1302
 * medium
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res = levelSum;
        }
        return res;
    }
}
