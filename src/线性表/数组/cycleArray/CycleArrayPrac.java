package 线性表.数组.cycleArray;

import java.util.NoSuchElementException;

public class CycleArrayPrac<T> {
   public T[] arr;
   public int start;
   public int end;
   public int count;
   public int size;

   public CycleArrayPrac() {
       this(1);
   }

   public CycleArrayPrac(int size) {
       this.arr = (T[])new Object[size];
       this.start = 0;
       this.end = 0;
       this.count = 0;
       this.size = size;
   }

   public void reSize(int newSize) {
       T[] newArr = (T[]) new Object[newSize];
       for (int i = 0; i < count; i++) {
           newArr[i] = arr[(i + start) % size];
       }
       this.arr = newArr;
       this.start = 0;
       this.end = count;
       this.size = newSize;
   }

   public void addFirst(T val) {
       if (isFull()) {
           reSize(size * 2);
       }
       start = (start - 1 + size) % size;
       arr[start] = val;
       count ++;
   }

   public void removeFirst() {
       if (isEmpty()) {
           throw new IllegalStateException("Array is Empty");
       }
       arr[start] = null;
       start = (start + 1) % size;
       count --;
       if (count > 0 && count == size/4) {
           reSize(size/2);
       }
   }

   public void addLast(T val) {
       if (isFull()) {
           reSize(size*2);
       }
       arr[end] = val;
       end = (end + 1) % size;
       count ++;
   }

   public void removeLast() {
       if (isEmpty()) {
           throw new IllegalStateException("Array is Empty");
       }
       end = (end - 1 + size) % size;
       arr[end] = null;
       count --;
       if (count > 0 && count == size/4) {
           reSize(size/2);
       }
   }
    public T getFirst() {
       if (isEmpty()) {
           throw new IllegalStateException("Array is Empty");
       }
       return arr[start];
    }
    public T getLast() {
       if (isEmpty()) {
           throw new IllegalStateException("Array is Empty");
       }
       return arr[end];
    }
   public boolean isFull() {
       return count == size;
   }
   public boolean isEmpty() {
       return count == 0;
   }
}