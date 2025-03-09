package 树.二叉树.二叉树的层序遍历;
import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣1609
 * medium
 */
public class EvenOddTree {
    public static boolean isEvenOddTree(TreeNode root) {
        if (root==null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean evenLevel = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode prev = null;
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                int curVal = node.val;
                if (evenLevel){
                    if (curVal%2==0){
                        return false;
                    } else {
                        if (prev!=null){
                            int preVal = prev.val;
                            if (!(preVal<curVal)){
                                return false;
                            }
                        }
                    }
                } else {
                    if (curVal%2==1){
                        return false;
                    } else {
                        if (prev!=null){
                            int preVal = prev.val;
                            if (!(preVal>curVal)){
                                return false;
                            }
                        }
                    }
                }
                if (node!=null){
                    prev = node;
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
//                                                                 1
//                                        10                                              4
//                            3                       null                    7                       9
//                    12              8                               6               null      null      2
    public static void main(String[] args) {
//        [1,10,4,3,null,7,9,12,8,6,null,null,2]
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(10);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);
        System.out.println(isEvenOddTree(root));
    }
}
