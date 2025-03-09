package 树.二叉搜索树.二叉搜索树心法_构造篇;
import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 力扣95
 * medium
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();
        return build(1, n);
    }
    public List<TreeNode> build(int lo, int hi){
        LinkedList<TreeNode> res = new LinkedList<>();
        if (lo>hi){
            res.add(null);
            return res;
        }
        for (int i=lo; i<=hi; i++) {
            List<TreeNode> left = build(lo, i - 1);
            List<TreeNode> right = build(i + 1, hi);
            for (TreeNode le : left) {
                for (TreeNode ri : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    root.right = ri;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
