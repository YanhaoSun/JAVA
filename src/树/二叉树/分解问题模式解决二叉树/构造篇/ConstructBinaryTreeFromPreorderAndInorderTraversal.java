package 树.二叉树.分解问题模式解决二叉树.构造篇;

import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * 力扣105
 * medium
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer, Integer> inOrderMap  = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if (preStart>preEnd){
            return null;
        }
        // 根据preOrder和inOrder的特点构建当前树的根结点
        int rootVal = preOrder[preStart];
        int index = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        // leftSize表示左子树的结点个数, 我们可以根据inOrder计算出左子树的结点个数,
        // 利用这个左子树的结点个数来计算preOrder中左子树的区间范围和preOrder中右子树的区间范围
        // 从而可以构造出当前结点的左子树和右子树
        // 从而构造出根结点
        int leftSize = index-inStart;
        root.left = build(preOrder, preStart+1, preStart+leftSize, inOrder,  inStart, index-1);
        root.right = build(preOrder, preStart+leftSize+1, preEnd, inOrder, index+1, inEnd);
        return root;
    }

    public TreeNode buildTreePrac(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return buildPrac(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode buildPrac(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if (preStart>preEnd){
            return null;
        }
        int rootVal = preOrder[preStart];
        int index = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int leftSize = index-inStart;
        root.left = buildPrac(preOrder, preStart+1, preStart+leftSize, inOrder, inStart, index-1);
        root.right = buildPrac(preOrder, preStart+leftSize+1, preEnd, inOrder, index+1, inEnd);
        return root;
    }
}