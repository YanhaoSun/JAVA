package 树.二叉树.二叉树的层序遍历;
import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 力扣662
 * medium
 */
public class MaximumWidthOfBinaryTree {
    public class Pair{
        TreeNode treeNode;
        int index;
        public Pair(TreeNode treeNode, int index){
            this.treeNode = treeNode;
            this.index = index;
        }
    }
    public int widthOfBinaryTree_1(TreeNode root) {
        if (root==null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        Pair rootPair = new Pair(root, 1);
        queue.offer(rootPair);
        int max = 0;
        int start = 0;
        int end = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                Pair pair = queue.poll();
                TreeNode cur = pair.treeNode;
                int curIndex = pair.index;
                if (i==0){
                    start = curIndex;
                }
                if (i==size-1){
                    end = curIndex;
                }
                if (cur.left!=null){
                    Pair pairLeft = new Pair(cur.left, 2*curIndex);
                    queue.offer(pairLeft);
                }
                if (cur.right!=null){
                    Pair pairRight = new Pair(cur.right, 2*curIndex+1);
                    queue.offer(pairRight);
                }
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public int widthOfBinaryTree_2(TreeNode root){
        if (root==null) return 0;
        traverse(root, 1, 1);
        return maxWidth;
    }
    ArrayList<Integer> left = new ArrayList<>();
    int maxWidth = 1;
    public void traverse(TreeNode root, int id, int depth){
        if (root==null) return;
        if (left.size()==depth-1){
            left.add(id);
        } else {
            maxWidth = Math.max(maxWidth, id-left.get(depth-1)+1);
        }
        traverse(root.left, 2*id, depth+1);
        traverse(root.right, 2*id+1, depth+1);
    }

    public static void main(String[] args) {
    }
}
