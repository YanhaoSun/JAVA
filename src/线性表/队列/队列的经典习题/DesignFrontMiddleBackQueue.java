package 线性表.队列.队列的经典习题;

import java.util.LinkedList;

public class DesignFrontMiddleBackQueue {
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();
    public void balance(){
        if (left.size()+1<right.size()){
            left.addLast(right.removeFirst());
        }
        if (left.size()>right.size()){
            right.addFirst(left.removeLast());
        }
    }
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (size()%2==0){
            right.addFirst(val);
        } else {
            left.addLast(val);
        }
        balance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        int e;
        if (size()==0){
            return -1;
        } else if (size()==1){
            return right.removeFirst();
        }
        e = left.removeFirst();
        balance();
        return e;
    }

    public int popMiddle() {
        if (size()==0){
            return -1;
        }
        int e;
        if (size()%2==0){
            e = left.removeLast();
        } else {
            e = right.removeFirst();
        }
        balance();
        return e;
    }

    public int popBack() {
        int e;
        if (size()==0){
            return -1;
        } else {
            e = right.removeLast();
        }
        balance();
        return e;
    }
    private int size(){
        return left.size()+right.size();
    }
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);

        a.addLast(9);
        a.addLast(8);
        a.addLast(7);
        a.addLast(6);

        for(int num: a){
            System.out.print(num+" ");
        }
        System.out.println();
        a.removeFirst();
        a.removeFirst();
        a.removeLast();
        a.removeLast();
        for(int num: a){
            System.out.print(num+" ");
        }
    }
}
