package 树.二叉树.二叉树的层序遍历;
import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣107
 * medium
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelTree = new LinkedList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                levelTree.add(node.val);
            }
            res.addFirst(levelTree);
        }
        return res;
    }
}
