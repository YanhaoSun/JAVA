package 线性表.栈.栈的经典习题;

import java.util.Stack;

/**
 * 力扣71
 * medium
 */
public class SimplifyPath {
    public String solution(String path) {
        String[] parts = path.split("/");
        Stack<String> stk = new Stack<>();
        for (String part: parts){
            if (part.isEmpty() || part.equals(".")){
                continue;
            }
            if (part.equals("..")){
                if (!stk.isEmpty()){
                    stk.pop();
                }
                continue;
            }
            stk.push(part);
        }
        String res = "";
        while (!stk.isEmpty()){
            res = "/"+stk.pop()+res;
        }
        return res.isEmpty()? "/":res;
    }

    public static void main(String[] args) {
//        String a = "/home/ /foo/";
        String a = "/../";
        String[] parts = a.split("/");
        for (String part: parts){
            System.out.print(part);
        }
    }
}
