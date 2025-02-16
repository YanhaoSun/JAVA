package 线性表.栈.栈的经典习题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 力扣388
 * medium
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Deque<String> stack = new LinkedList<>();
        String[] dirs = input.split("\n");
        int maxLen = 0;
        for (String dir: dirs){
            int level = dir.lastIndexOf("\t")+1;
            while (level<stack.size()){
                stack.removeLast();
            }
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
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String[] res = input.split("\n");
        for (String part: res){
            System.out.println(part);
            System.out.println(part.substring(2));
            System.out.println(part.lastIndexOf("\t"));
        }
    }
}
