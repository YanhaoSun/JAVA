package 树.二叉树.分解问题模式解决二叉树.序列化篇;
import BinaryTree.TreeNode;
//import apple.laf.JRSUIUtils;
//import jdk.vm.ci.sparc.SPARC;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣297
 * hard
 */
public class SerializeAndDeserializeBinaryTree {

    String SEP = ",";
    String NULL = "#";

    /**
     * 使用前序进行序列化和反序列化二叉树
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize_1(TreeNode root) {
        StringBuilder string = new StringBuilder();
        _serialize_1(root, string);
        return string.toString();
    }
    public void _serialize_1(TreeNode root, StringBuilder string){
        if (root==null){
            string.append(NULL).append(SEP);
            return;
        }
        string.append(root.val).append(SEP);
        _serialize_1(root.left, string);
        _serialize_1(root.right, string);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_1(String data) {
        LinkedList<String> string = new LinkedList<>();
        for (String s: data.split(SEP)){
            string.addLast(s);
        }
        return _deserialize_1(string);
    }
    public TreeNode _deserialize_1(LinkedList<String> data){
        if (data.isEmpty()) return null;

        // 前序
        String node = data.removeFirst();
        if (node.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));

        root.left = _deserialize_1(data);
        root.right = _deserialize_1(data);

        return root;
    }

    /**
     * 使用后序进行序列化和反序列化二叉树
     */
    public String serialize_2(TreeNode root) {
        StringBuilder string = new StringBuilder();
        _serialize_2(root, string);
        return string.toString();
    }
    public void _serialize_2(TreeNode root, StringBuilder string){
        if (root==null){
            string.append(NULL).append(SEP);
            return;
        }
        _serialize_2(root.left, string);
        _serialize_2(root.right, string);
        string.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_2(String data) {
        LinkedList<String> string = new LinkedList<>();
        // 因为后序遍历的根结点在最后面, 所以从根结点开始往左走: 左子树 <- 右子树 <- 根结点
        // 我们可以用addFirst, 也可以用addLast, 将元素存入linkedList
        // 使用addFirst: 构造出来的linkedList中, 根结点就在最前面了, 从左往右遍历是: 根结点 -> 右子树 -> 左子树
        // 使用addLast: 构造出来的linkedList中, 根结点还是在最右边, 从根结点开始往左走: 左子树 <- 右子树 <- 根结点
        for (String d: data.split(SEP)){
            string.addFirst(d);
        }
        return _deserialize_2(string);
    }
    public TreeNode _deserialize_2(LinkedList<String> data){
        if (data.isEmpty())return null;

        // 在二叉树的构造问题中, 我们的思路是: 树 = 根结点 + 左子树/右子树 + 右子树/左子树
        String node = data.removeFirst();
        if (node.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));

        // 先构造右子树, 再构造左子树
        root.right = _deserialize_2(data);
        root.left = _deserialize_2(data);
        return root;
    }

    /**
     * 使用层及遍历(Queue)进行序列化和反序列化
     */
    public String serialize_3(TreeNode root) {
        if (root==null) return "";
        StringBuilder string = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node==null){
                    string.append(NULL).append(SEP);
                    continue;
                }
                string.append(node.val).append(SEP);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return string.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_3(String data) {
        if (data.isEmpty()) return null;
        String[] string = data.split(SEP);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(string[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode parent = queue.poll();
                String left = string[index++];
                if (!left.equals(NULL)){
                    parent.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(parent.left);
                }
                String right = string[index++];
                if (!right.equals(NULL)){
                    parent.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(parent.right);
                }
            }
        }
        return root;
    }
}
