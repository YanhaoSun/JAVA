package 线性表.栈.栈的经典习题;

import java.util.Stack;

public class MinStackSolution2 {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStk = new Stack<>();
    public MinStackSolution2() {

    }

    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty()){
            minStk.push(val);
        } else {
            if (val<minStk.peek()){
                minStk.push(val);
            } else {
                minStk.push(minStk.peek());
            }
        }
    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}
