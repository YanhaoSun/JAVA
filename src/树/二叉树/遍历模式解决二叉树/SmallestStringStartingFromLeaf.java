package 树.二叉树.遍历模式解决二叉树;
import BinaryTree.TreeNode;
import com.sun.xml.internal.ws.message.stream.StreamAttachment;

import java.util.LinkedList;

/**
 * 力扣988
 * medium
 */
public class SmallestStringStartingFromLeaf {

    StringBuilder path = new StringBuilder();
    String res = null;
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        if (root.left==null && root.right==null){
//            path.addLast(root.val);
            path.append((char) ('a'+root.val));
            path.reverse();
            String s = path.toString();
            if (res==null || res.compareTo(s)>0){
                res = s;
            }
            path.reverse();
            path.deleteCharAt(path.length()-1);
            return;
        }
        path.append((char)('a'+root.val));
//        path.addLast(root.val);
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length()-1);
    }

    public static void main(String[] args) {
//        root = [25,1,3,1,3,0,2]
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        SmallestStringStartingFromLeaf test = new SmallestStringStartingFromLeaf();
        String result = test.smallestFromLeaf(root);
        System.out.println(result);
    }
}
