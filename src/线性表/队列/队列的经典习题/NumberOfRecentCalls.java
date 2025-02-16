package 线性表.队列.队列的经典习题;

import list.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣933
 * easy
 */
public class NumberOfRecentCalls {
    class RecentCounter {
        Queue<Integer> requests;
        public RecentCounter() {
            requests = new LinkedList<>();
        }

        public int ping(int t) {
            requests.offer(t);
            while (requests.peek()<t-3000) requests.poll();
            return requests.size();
        }
    }
}
