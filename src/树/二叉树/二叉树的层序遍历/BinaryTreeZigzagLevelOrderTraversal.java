package 树.二叉树.二叉树的层序遍历;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣103
 * medium
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<List<Integer>> res = new LinkedList<>();
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> treeLevel = new LinkedList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
                if (flag) {
                    treeLevel.addLast(node.val);
                } else {
                    treeLevel.addFirst(node.val);
                }
            }
            res.add(treeLevel);
            flag = !flag;
        }
        return res;
    }
}
