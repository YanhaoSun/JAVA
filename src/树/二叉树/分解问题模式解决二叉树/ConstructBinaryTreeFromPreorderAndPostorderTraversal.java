package 树.二叉树.分解问题模式解决二叉树;
import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * 力扣889
 * medium
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    HashMap<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i=0; i<postorder.length; i++){
            postMap.put(postorder[i], i);
        }
        return traverse(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if (preStart>preEnd) return null;
        if (preStart==preEnd) return new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart+1];
        int index = postMap.get(leftRootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index-postStart+1;
        root.left = traverse(preorder, preStart+1, preStart+leftSize, postorder, postStart, index);
        root.right = traverse(preorder, preStart+leftSize+1, preEnd, postorder, index+1, postEnd-1);
        return root;
    }
}
