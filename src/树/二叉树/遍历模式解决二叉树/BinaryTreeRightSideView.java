package 树.二叉树.遍历模式解决二叉树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;

/**
 * 力扣199
 * medium
 */
public class BinaryTreeRightSideView {

    /**
     * BFS层序遍历法
     * @param root
     * @return
     */
    public List<Integer> rightSideView_BFS(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode last = queue.peek();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
            }
            result.add(last.val);
        }
        return result;
    }
    /**
     * DFS递归法
     */
    private List<Integer> result = new LinkedList<>();
    private int depth = 0;
    public List<Integer> rightSideView_DFS(TreeNode root){
        traverse(root);
        return result;
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        depth++;
        if (result.size()<depth){
            result.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth--;
    }


}
