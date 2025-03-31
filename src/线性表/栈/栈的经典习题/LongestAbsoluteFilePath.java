package 线性表.栈.栈的经典习题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 力扣388
 * medium
 */
public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        Deque<String> stack = new LinkedList<>();
        String[] dirs = input.split("\n");
        int maxLen = 0;
        for (String dir: dirs){
            int level = dir.lastIndexOf("\t")+1;
            System.out.println("before stack.size() = "+stack.size());
            while (level<stack.size()){
                stack.removeLast();
            }
            System.out.println("after stack.size() = "+stack.size());
            System.out.println("dir = "+dir);
            System.out.println("level = "+level);
            System.out.println("dir.substring(level) = "+dir.substring(level));
            System.out.println();
            stack.addLast(dir.substring(level));
            if (dir.contains(".")){
                int sum = stack.stream().mapToInt(String::length).sum();
                sum += stack.size()-1;
                maxLen = Math.max(sum, maxLen);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
//        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//        lengthLongestPath(input);
//        String[] res = input.split("\n");
//        for (String part: res){
//            System.out.println(part);
//            System.out.println(part.substring(2));
//            System.out.println(part.lastIndexOf("\t"));
//            System.out.println();
//        }
        String a = "\nfff\ta\t";/**/
        String[] res = a.split("\n");
        for (String m: res){
            System.out.println(m);
        }
//        System.out.println(res[0]);
        String[] temp = new String[]{"\t\tfffa"};
        System.out.println(temp[0].lastIndexOf("\t")+1);
//        System.out.println(a.substring(3));
//        Stack<Integer> stack = new Stack<>();

    }
}
