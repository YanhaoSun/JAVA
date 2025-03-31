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
    class MyCircularQueueSolution2{
        int[] queue;
        int start;
        int last;
        int size;
        int first = 0;
        int rear = 0;
        public MyCircularQueueSolution2(int k) {
            queue = new int[k];
            start = 0;
            last = 0;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (size==queue.length){
                return false;
            }
            queue[last] = value;
            last++;
            if (last==queue.length){
                last = 0;
            }
            size++;
            return true;
        }

        public boolean deQueue() {
            if (size==0){
                return false;
            }
            queue[start] = 0;
            start++;
            if (start==queue.length){
                start = 0;
            }
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return queue[start];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            if (last==0) return queue[queue.length-1];
            return queue[last-1];
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size==queue.length;
        }
    }
}
