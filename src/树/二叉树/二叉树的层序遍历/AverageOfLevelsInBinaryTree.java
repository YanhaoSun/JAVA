package 树.二叉树.二叉树的层序遍历;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣637
 * easy
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> res = new LinkedList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0.0;
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            res.add(sum/size);
        }
        return res;
    }
}
