package 树.二叉树.分解问题模式解决二叉树;

import java.util.LinkedList;

/**
 * 力扣331
 * medium
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization_solution1(String preorder) {
        int edge = 1;
        for (String node: preorder.split(",")){
            if (node.equals("#")){
                edge --;
                if (edge<0){
                    return false;
                }
            } else {
                edge --;
                if (edge<0){
                    return false;
                }
                edge += 2;
            }
        }
        return edge==0;
    }

    public boolean isValidSerialization_solution2(String preorder){
        LinkedList<String> nodes = new LinkedList<>();
        for (String node: preorder.split(",")){
            nodes.addLast(node);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }
    public boolean deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()) return false;

        String first = nodes.removeFirst();
        if (first.equals("#")) return true;

        return deserialize(nodes) && deserialize(nodes);
    }
}
