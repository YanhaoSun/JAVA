package BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leet_111_minDepth {
    private int minDepth = Integer.MAX_VALUE;
    private int currDepth = 0;

    // DFS solution
    public int minDepth_DFS(TreeNode root){
        if (root==null){
            return 0;
        }
        dfsTraverse(root);
        return minDepth;
    }
    public void dfsTraverse(TreeNode root){
        if (root==null){
            return;
        }
        currDepth++;
        if (root.left==null && root.right==null){
            minDepth = Math.min(minDepth, currDepth);
        }
        dfsTraverse(root.left);
        dfsTraverse(root.right);
        currDepth--;
    }

    public int bfsMinDepthTraverse(TreeNode root){
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if (cur.left==null && cur.right==null){
                    return depth;
                }
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
