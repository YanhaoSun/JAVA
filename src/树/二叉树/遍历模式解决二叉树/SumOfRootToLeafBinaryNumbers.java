package 树.二叉树.遍历模式解决二叉树;
import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * 力扣1022
 * easy
 */
public class SumOfRootToLeafBinaryNumbers {
    StringBuilder path = new StringBuilder();
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return sum;
    }
    public void traverse(TreeNode root){
        if (root==null) return;

        if (root.left==null && root.right==null){
            path.append(root.val);
            String s = path.toString();
            sum += calculateBinary(s);
            path.deleteCharAt(path.length()-1);
            return;
        }
        path.append(root.val);
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length()-1);
    }
    public static int calculateBinary(String s){
        int sum = 0;
        for (int i=0; i<s.length(); i++){
            int b = Character.getNumericValue(s.charAt(i));
            sum += Math.pow(2, s.length()-1-i)*b;
        }
        return sum;
    }

    int path_2  = 0;
    int sum_2 = 0;
    public int sumRootToLeaf_2(TreeNode root) {
        traverse_2(root);
        return sum_2;
    }
    public void traverse_2(TreeNode root){
        if (root==null) return;

        if (root.left==null && root.right==null){
            sum_2 += path_2 << 1 | root.val;
            return;
        }
        path_2 = path_2 <<1 | root.val;
        traverse(root.left);
        traverse(root.right);
        path_2 = path_2 >> 1;
    }

    public static void main(String[] args) {
//        System.out.println(calculateBinary("100"));
        Character c = '1';
        System.out.println(Character.valueOf(c)+1);
    }
}
