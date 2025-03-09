package 树.二叉树.分解问题模式解决二叉树;
import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * 力扣106
 * medium
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (postStart>postEnd) return null;
        int rootVal = postorder[postEnd];
        int index = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int leftSize = index-inStart;
        root.left = build(inorder, inStart, index-1, postorder, postStart, postStart+leftSize-1);
        root.right = build(inorder, index+1, inEnd, postorder, postStart+leftSize, postEnd-1);
        return root;
    }
}
