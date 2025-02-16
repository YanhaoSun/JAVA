package 线性表.队列.队列的经典习题;

import 线性表.队列.循环数组实现队列.ArrayQueue;

/**
 * 力扣622
 * medium
 */
public class DesignCircularQueue {
    class MyCircularQueue {
        ArrayQueue<Integer> circularQueue;
        int maxCap;
        public MyCircularQueue(int k) {
            circularQueue = new ArrayQueue<>(k);
            maxCap = k;
        }

        public boolean enQueue(int value) {
            if (circularQueue.size()==maxCap){
                return false;
            }
            circularQueue.enqueue(value);
            return true;
        }

        public boolean deQueue() {
            if (circularQueue.size()==0){
                return false;
            }
            circularQueue.dequeue();
            return true;
        }

        public int Front() {
            if (circularQueue.size()==0){
                return -1;
            }
            return circularQueue.peekFirst();
        }

        public int Rear() {
            if (circularQueue.size()==0){
                return -1;
            }
            return circularQueue.peekLast();
        }

        public boolean isEmpty() {
            return circularQueue.isEmpty();
        }

        public boolean isFull() {
            return circularQueue.size()==maxCap;
        }

    }
}
