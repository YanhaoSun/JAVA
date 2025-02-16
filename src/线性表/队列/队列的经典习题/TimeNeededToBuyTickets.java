package 线性表.队列.队列的经典习题;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy1(int[] tickets, int k) {
        int count = 0;
        for (int i=0; i<tickets.length; i++){
            if (i<k){
                count += Math.min(tickets[i], tickets[k]);
            } else if (i>k){
                count += Math.min(tickets[i]-1, tickets[k]);
            } else {
                count += tickets[k];
            }
        }
        return count;
    }
    public static int timeRequiredToBuy2(int[] tickets, int k) {
        if (tickets.length==1){
            return tickets[0];
        }
        int count = 0;
        HelperQueue<HashMap<Integer, Integer>> queue = new HelperQueue<>(tickets.length);
        for (int i=0; i<tickets.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(i, tickets[i]);
            queue.enqueue(map);
        }
        int index = 0;
        while (!queue.isEmpty()){
            HashMap<Integer, Integer> temp = queue.dequeue();
            if (temp.containsKey(k) && temp.get(k)==1){
                count++;
                break;
            }
            if (temp.get(index)>0){
                queue.enqueue(temp);
                temp.put(index, temp.get(index)-1);
                count++;
            } else {
                // 不进行dequeue是为了维护index保持不变,方便引用, 但是不进行count的统计
                queue.enqueue(temp);
            }
            index = (index+1)%tickets.length;
        }
        return count;
    }
    public static class HelperQueue<E>{
        E[] circularQueue;
        int start, end;
        int size;
        int count;
        public HelperQueue(int size){
            circularQueue = (E[]) new Object[size];
            start = end = 0;
            this.size = size;
            count = 0;
        }
        public void enqueue(E val){
            if (count==size){
                resize(2*size);
            }
            circularQueue[end] = val;
            end = (end+1)%size;
            count++;
        }
        public E dequeue(){
            if (isEmpty()){
                throw new NoSuchElementException();
            }
            E oldVal = circularQueue[start];
            circularQueue[start] = null;
            start = (start+1)%size;
            count--;
            if (count==size/4){
                resize(size/2);
            }
            return oldVal;
        }
        public void resize(int newSize){
            E[] temp = (E[]) new Object[newSize];
            for (int i=0; i<count; i++){
                temp[i] = circularQueue[(start+i)%size];
            }
            start = 0;
            end = count;
            size = newSize;
            circularQueue = temp;
        }
        public E peekFirst(){
            if (isEmpty()){
                throw new NoSuchElementException();
            }
            return circularQueue[start];
        }
        public E peekLast(){
            if (isEmpty()){
                throw new NoSuchElementException();
            }
            return circularQueue[end-1];
        }
        public boolean isEmpty(){
            return count==0;
        }
    }

    public static void main(String[] args) {
        int[] time = {100};
        int k = 0;
        int res = timeRequiredToBuy2(time, k);
        System.out.println(res);
    }

}
