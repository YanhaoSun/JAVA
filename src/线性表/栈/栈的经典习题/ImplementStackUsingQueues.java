package 线性表.栈.栈的经典习题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣225
 * easy
 */
public class ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        int topEle = 0;
        public MyStack() {

        }

        public void push(int x) {
            q.offer(x);
            topEle = x;
        }

        public int pop() {
            int size = q.size();
            while (size>2){
                q.offer(q.poll());
                size--;
            }
            topEle = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        public int top() {
            return topEle;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
