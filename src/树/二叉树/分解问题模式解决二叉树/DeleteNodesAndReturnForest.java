package 树.二叉树.分解问题模式解决二叉树;
import BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 力扣1110
 * medium
 */
public class DeleteNodesAndReturnForest {
    Set<Integer> delSet = new HashSet<>();

    List<TreeNode> treeNodes = new LinkedList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root==null) return null;
        for (int del: to_delete){
            delSet.add(del);
        }
        delHelper(root, false);
        return treeNodes;
    }
    // 定义递归函数: 输入一颗二叉树, 删除delSet中的节点, 返回删除节点后的树的根结点
    public TreeNode delHelper(TreeNode root, boolean hasParent){
        if (root==null) return null;
        boolean deleted = delSet.contains(root.val);
        if (!deleted && !hasParent){
            treeNodes.add(root);
        }
        root.left = delHelper(root.left, !deleted);
        root.right = delHelper(root.right, !deleted);
        return deleted? null:root;
    }
}
