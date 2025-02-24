package 树.二叉树.分解问题模式解决二叉树.构造篇;

import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * 力扣106
 * medium
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    HashMap<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        if (postStart>postEnd){
            return null;
        }
        // 构造根结点
        // 因为post order是在遍历了左子树和右子树之后, 所以在遍历了左子树和右子树之后才能到达根结点
        // 所以post order最后一个结点就是根结点, 往左先是右子树, 然后才是左子树
        int rootVal = postOrder[postEnd];
        int index = inMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        // 因为post order往左不确定根结点在哪里, 所以需要inorder来确定右子树的大小
        // 然后根据右子树的大小计算postorder左子树和右子树的indices
        int rightSize = inEnd-index;
        root.right = build(inOrder, index+1, inEnd, postOrder, postEnd-rightSize, postEnd-1);
        root.left = build(inOrder, inStart, index-1, postOrder, postStart, postEnd-rightSize-1);
        return root;
    }
}
