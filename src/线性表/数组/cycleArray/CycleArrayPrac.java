package 线性表.数组.cycleArray;

import java.util.NoSuchElementException;

public class CycleArrayPrac<E> {
    E[] cycleArray;
    int start, end;
    int count;
    public CycleArrayPrac(int cap){
        cycleArray = (E[]) new Object[cap];
        start = end = 0;
        count = 0;
    }
    public void addFirst(E val){
        if (isFull()){
            resize(size()*2);
        }
        start = (start-1+size())%size();
        cycleArray[start] = val;
        count++;
    }
    public void addLast(E val){
        if (isFull()){
            resize(size()*2);
        }
        cycleArray[end] = val;
        end = (end+1)%size();
        count++;
    }
    public void resize(int newSize){
        E[] temp = (E[]) new Object[newSize];
        for (int i=0; i<count; i++){
            temp[i] = cycleArray[(start+i)%size()];
        }
        start = 0;
        end = count;
        cycleArray = temp;
    }
    public E removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (count==size()/4){
            resize(size()/2);
        }
        E oldVal = cycleArray[start];
        cycleArray[start] = null;
        start = (start+1)%size();
        count--;
        return oldVal;
    }
    public E removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (count==size()/4){
            resize(size()/2);
        }
        E oldVal = cycleArray[end-1];
        cycleArray[end-1] = null;
        end = (end-1)%size();
        count--;
        return oldVal;
    }
    public E getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return cycleArray[start];
    }
    public E getLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        end = (end-1+size())%size();
        return cycleArray[end];
    }
    public boolean isEmpty(){
        return count==0;
    }
    public int size(){
        return count;
    }
    public boolean isFull(){
        return count==cycleArray.length;
    }
}
