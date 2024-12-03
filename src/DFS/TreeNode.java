package DFS;

import list.ListNode;

import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){};
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public static TreeNode initialiseTree(List<Integer> tree, int index){
        TreeNode root = new TreeNode();
        if (tree.get(index)==null){
            return null;
        }
        if (index<tree.size()){
            root = new TreeNode(tree.get(index));
        }
        if ((index*2+1) < tree.size()){
            root.left = initialiseTree(tree, (index*2+1));
        }
        if ((index*2+2) < tree.size()){
            root.right = initialiseTree(tree, (index*2+2));
        }
        return root;
    }
}
