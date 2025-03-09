package 树.二叉树.二叉树的层序遍历;
import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣958
 * medium
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node==null){
                    end = true;
                } else {
                    if (end){
                        return false;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
