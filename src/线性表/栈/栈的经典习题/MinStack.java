package 线性表.栈.栈的经典习题;

//import jdk.javadoc.internal.doclets.toolkit.taglets.UserTaglet;

import java.util.Stack;

/**
 * 力扣155
 * medium
 */
public class MinStack {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        a.push(val);
        if (b.isEmpty() || val<=b.peek()){
            b.push(val);
        }
    }

    public void pop() {
        if (a.peek().equals(b.peek())){
            b.pop();
        }
        a.pop();
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }
}
