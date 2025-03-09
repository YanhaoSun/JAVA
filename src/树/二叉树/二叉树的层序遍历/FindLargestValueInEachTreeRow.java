package 树.二叉树.二叉树的层序遍历;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;
import sun.awt.image.ImageWatched;

/**
 * 力扣515
 * medium
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            int Max = Integer.MIN_VALUE;
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (node.val>Max){
                    Max = node.val;
                }
            }
            res.add(Max);
        }
        return res;
    }
}
