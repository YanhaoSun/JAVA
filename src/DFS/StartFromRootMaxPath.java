package DFS;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StartFromRootMaxPath {
    /**
     * 使用递归计算从根节点出发的最大路径和问题
     */
    public static int DFS(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = Math.max(DFS(root.left), 0);
        int right = Math.max(DFS(root.right), 0);
//        int left = DFS(root.left);
//        int right = DFS(root.right);
        return root.val+Math.max(left, right);
    }

    /**
     * 使用stack无法计算得到最大路径和, 但是可以用来计算所有路径的总和
     */
    public static int DFSStack(List<Integer> tree){
        int sum = tree.get(0);
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[tree.size()];
        stack.push(0);
        visited[0] = true;
        while(!stack.empty()){
            int root = stack.peek();
            int left = 2*root+1;
            int right = 2*root+2;
            if (left<tree.size() && !visited[left] && tree.get(left)!=null){
                stack.push(left);
                visited[left] = true;
                sum += tree.get(left);
                continue;
            }
            if (right<tree.size() && !visited[right] && tree.get(right)!=null){
                stack.push(right);
                visited[right] = true;
                sum += tree.get(right);
                continue;
            }
            stack.pop();
        }
        return sum;
    }
    public static int DFSStack1(List<Integer> tree){
        int sum = tree.get(0);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        boolean[] visited = new boolean[tree.size()];
        while (!stack.empty()){
            int root = stack.peek();
            int left = 2*root+1;
            int right = 2*root+2;
            if (left<tree.size() && !visited[left] && tree.get(left)!=null){
                stack.push(left);
                visited[left] = true;
                sum += tree.get(left);
                continue;
            }
            if (right<tree.size() && !visited[right] && tree.get(right)!=null){
                stack.push(right);
                visited[right] = true;
                sum += tree.get(right);
                continue;
            }
            stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> tree = new ArrayList<>();
//        Arrays.asList(-10,9,20,null,null,15,7)
        tree.add(-10);
        tree.add(9);
        tree.add(20);
        tree.add(null);
        tree.add(null);
        tree.add(15);
        tree.add(7);
        TreeNode root = TreeNode.initialiseTree(tree,0);
        int result = DFSStack1(tree);
        System.out.println(result);
    }
}
