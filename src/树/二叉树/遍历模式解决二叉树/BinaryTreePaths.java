package 树.二叉树.遍历模式解决二叉树;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 力扣257
 * easy
 */
public class BinaryTreePaths {
    LinkedList<String> path = new LinkedList<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return result;
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        if (root.left==null && root.right==null){
            path.addLast(root.val+"");
            result.addLast(String.join("->", path));
            path.removeLast();
        }
        path.addLast(root.val+"");
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }

//    LinkedList<String> res = new LinkedList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        LinkedList<String> path = new LinkedList<>();
//        traverse(root, path);
//        return res;
//    }
//    public void traverse(TreeNode root, LinkedList<String> path){
//        if (root==null){
//            return;
//        }
//        if(root.left==null && root.right==null){
//            path.addLast(root.val+"");
//            res.addLast(String.join("->", path));
//            path.removeLast();
//            // return;
//        }
//        path.addLast(root.val+"");
//
//        traverse(root.left, path);
//        traverse(root.right, path);
//
//        path.removeLast();
//    }



    public static void main(String[] args) {
//        LinkedList<String> a = new LinkedList<>();
//        a.addLast("1");
//        a.addLast("2");
//        LinkedList<String> result = new LinkedList<>();
//        result.addLast(String.join("", a));
//        System.out.println(Integer.parseInt(String.join("", result)));

        String a = "1";
        System.out.println(Integer.parseInt(a));
        StringBuilder sb = new StringBuilder();
        sb.append((char)(1+'a'));
//        sb.charAt(Integer.par);
    }
}
