package 线性表.队列.栈实现队列;

import java.util.Stack;

/**
 * 力扣232
 * easy
 */
public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> s1, s2;
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            peek();
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
