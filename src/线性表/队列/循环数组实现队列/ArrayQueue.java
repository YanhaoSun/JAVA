package 线性表.队列.循环数组实现队列;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E>{
    private int size;
    private E[] data;
    private final static int INIT_CAP = 2;
    private int first, last;
    public ArrayQueue(int initCap){
        size = 0;
        data = (E[])new Object[initCap];
        first = last = 0;
    }
    public ArrayQueue(){
        this(INIT_CAP);
    }
    public void enqueue(E e){
        if (size==data.length){
            resize(size*2);
        }
        data[last] = e;
        last++;
        if (last == data.length){
            last = 0;
        }
        size++;
    }
    public E dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (size == data.length/4){
            resize(data.length/2);
        }
        E oldVal = data[first];
        data[first] = null;
        first++;
        if (first== data.length){
            first = 0;
        }
        size --;
        return oldVal;
    }
    private void resize(int newCap){
        E[] temp = (E[]) new Object[newCap];
        for (int i=0; i<size; i++){
            temp[i] = data[(first+i)% data.length];
        }
        first = 0;
        last = size;
        data = temp;
    }
    public E peekFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return data[first];
    }
    public E peekLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (last==0) return data[data.length-1];
        return data[last-1];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
