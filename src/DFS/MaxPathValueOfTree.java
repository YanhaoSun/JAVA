package DFS;

import java.util.ArrayList;
import java.util.List;

public class MaxPathValueOfTree {
    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathValue(TreeNode node){
        DFS(node);
        return maxSum;
    }
    public static int DFS(TreeNode node){
        if (node==null) return 0;
        int left = Math.max(DFS(node.left), 0);
        int right = Math.max(DFS(node.right), 0);
        int nodeGain = node.val+left+right;
        maxSum = Math.max(maxSum, nodeGain);
        return node.val+Math.max(left, right);
    }

    public static int maxPathValue1(TreeNode node){
        DFS(node);
        return maxSum;
    }
    public static int DFS1(TreeNode node){
        if (node==null) return 0;
        int left = Math.max(DFS1(node.left), 0);
        int right = Math.max(DFS1(node.right), 0);
        int nodeGain = node.val+left+right;
        maxSum = Math.max(maxSum, nodeGain);
        return node.val+Math.max(left, right);
    }

    public static void main(String[] args) {
        List<Integer> tree = new ArrayList<>();
        tree.add(-10);
        tree.add(9);
        tree.add(20);
        tree.add(null);
        tree.add(null);
        tree.add(15);
        tree.add(7);
        TreeNode root = TreeNode.initialiseTree(tree,0);
        int result = maxPathValue1(root);
        System.out.println(result);
    }
}
