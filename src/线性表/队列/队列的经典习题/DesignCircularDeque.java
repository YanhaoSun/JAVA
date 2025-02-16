package 线性表.队列.队列的经典习题;

import 线性表.队列.循环数组实现双端队列.MyArrayDeque;

/**
 * 力扣641
 * medium
 */
public class DesignCircularDeque {
    public static class MyCircularDeque {
        MyArrayDeque<Integer> arrayDeque;
        int maxCap;
        public MyCircularDeque(int k) {
            arrayDeque = new MyArrayDeque<>(k);
            maxCap = k;
        }

        public boolean insertFront(int value) {
            if (this.isFull()){
                return false;
            }
            arrayDeque.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (this.isFull()){
                return false;
            }
            arrayDeque.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (this.isEmpty()){
                return false;
            }
            arrayDeque.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (this.isEmpty()){
                return false;
            }
            arrayDeque.removeLast();
            return true;
        }

        public int getFront() {
            if (arrayDeque.isEmpty()) {
                return -1;
            }
            return arrayDeque.getFirst();
        }

        public int getRear() {
            if (arrayDeque.isEmpty()){
                return -1;
            }
            return arrayDeque.getLast();
        }

        public boolean isEmpty() {
            return arrayDeque.isEmpty();
        }

        public boolean isFull() {
            return arrayDeque.size()==maxCap;
        }
    }

    public static void main(String[] args) {
//        ["MyCircularDeque","insertFront","deleteLast","getRear","getFront",
//        "getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
//        [[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
        MyCircularDeque a = new MyCircularDeque(4);
        a.insertFront(9);
        a.deleteLast();
        a.getRear();
        a.getFront();
        a.getFront();
        a.deleteFront();
        a.insertFront(6);
        a.insertLast(5);
        a.insertFront(9);
        a.getFront();
        a.insertFront(6);
    }
}
