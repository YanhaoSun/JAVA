package 线性表.队列.循环数组实现双端队列;

import java.util.NoSuchElementException;

public class MyArrayDeque<E> {
    private int size;
    private E[] circularDeque;
    private int start, end;
    private final static int INI_CAP = 2;
    private int count;
    public MyArrayDeque(int cap){
        circularDeque = (E[]) new Object[cap];
        size = cap;
        start = end = 0;
        count = 0;
    }
    public MyArrayDeque(){
        this(INI_CAP);
    }
    public void addFirst(E val){
        if (isFull()){
            resize(size*2);
        }
        start = (start-1+size)%size;
        circularDeque[start] = val;
        count++;
    }
    public void addLast(E val){
        if (isFull()){
            resize(size*2);
        }
        circularDeque[end] = val;
        end = (end+1)%size;
        count++;
    }
    private void resize(int newSize){
        E[] temp = (E[]) new Object[newSize];
        for (int i=0; i<size(); i++){
            temp[i] = circularDeque[(start+i)%circularDeque.length];
        }
        start = 0;
        end = count;
        circularDeque = temp;
        size = newSize;
    }
    public E getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return circularDeque[start];
    }
    public E getLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return circularDeque[(end-1+size)%size];
    }
    public E removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (count==circularDeque.length/4){
            resize(circularDeque.length/2);
        }
        E oldVal = circularDeque[start];
        circularDeque[start] = null;
        start = (start+1)%circularDeque.length;
        count--;
        return oldVal;
    }
    public E removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (count== circularDeque.length/4){
            resize(circularDeque.length/2);
        }
        end = (end-1+size)%size;
        E oldVal = circularDeque[end];
        circularDeque[end] = null;
        count--;
        return oldVal;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public int size(){
        return count;
    }
    public boolean isFull(){
        return circularDeque.length==count;
    }
}