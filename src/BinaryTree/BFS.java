package BinaryTree;

//import apple.laf.JRSUIUtils;
//import com.sun.jdi.connect.spi.TransportService;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void levelOrderTraverse_1(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left!=null){
                queue.offer(cur.left);
            }
            if (cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }
    public void levelOrderTraverse_2(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
    }
    public void levelOrderTraverse_3(TreeNode root){
        if (root==null){
            return;
        }
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 1));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                State cur = queue.poll();
                if (cur.treeNode.left!=null){
                    queue.offer(new State(cur.treeNode.left, cur.depth+1));
                }
                if (cur.treeNode.right!=null){
                    queue.offer(new State(cur.treeNode.right, cur.depth+1));
                }
            }
        }
    }
}
