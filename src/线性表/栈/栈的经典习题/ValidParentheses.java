package 线性表.栈.栈的经典习题;

import java.util.Stack;

/**
 * 力扣20
 * easy
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                parentheses.push(c);
            } else {
                if (!parentheses.isEmpty() && leftOf(c)==parentheses.peek()){
                    parentheses.pop();
                } else {
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }
    public char leftOf(char c){
        if (c==')') return '(';
        if (c==']') return '[';
        return '{';
    }
}
