package 树.二叉树.分解问题模式解决二叉树;
import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * 力扣105
 * medium
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preStart;
    int preEnd;
    int inStart;
    int inEnd;
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if (preStart>preEnd) return null;

        int rootVal = preOrder[preStart];
        int index = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index-inStart;

        root.left = build(preOrder, preStart+1, preStart+leftSize, inOrder, inStart, index-1);
        root.right = build(preOrder, preStart+leftSize+1, preEnd, inOrder, index+1, inEnd);
        return root;
    }
}
