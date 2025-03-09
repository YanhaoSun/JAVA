package 树.二叉树.遍历模式解决二叉树;
import BinaryTree.TreeNode;
/**
 * 力扣1457
 * medium
 */
public class PseudoPalindromicPathsInABinaryTree {
    int[] count = new int[10];
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if (root==null) return;

        if (root.left==null && root.right==null){
            count[root.val]++;
            int odd = 0;
            for (int i: count) {
                if (i % 2 == 1) {
                    odd++;
                }
            }
            if (odd<=1){
                res++;
            }
            count[root.val]--;
            return;
        }
        count[root.val]++;
        traverse(root.left);
        traverse(root.right);
        count[root.val]--;
    }
}
