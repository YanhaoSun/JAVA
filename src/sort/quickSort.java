package sort;

import java.util.HashMap;

public class quickSort {
    public static int[] quickSortAlgo(int[] array, int left, int right){
        int mid = 0;
        if (left < right){
            mid = partition(array, left, right);
            quickSortAlgo(array, left, mid);
            quickSortAlgo(array, mid+1, right);
        }
        return array;
    }
    public static int partition(int[] array, int left, int right){
        int pivot = array[left];
        while(left < right){
            while(left<right && array[right] >= pivot){
                right --;
            }
            array[left] = array[right];
            while (left<right && array[left] <= pivot){
                left ++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    public static int[] quickSortAlgo1(int[] array, int left, int right){
        int mid = 0;
        if (left < right){
            mid = partition1(array, left, right);
            quickSortAlgo1(array, left, mid-1);
            quickSortAlgo1(array, mid+1, right);
        }
        return array;
    }
    public static int partition1(int[] array, int left, int right){
        int pivot = array[left];
        while (left < right){
            while (left<right && array[right]>=pivot){
                right --;
            }
            array[left] = array[right];
            while (left<right && array[left]<=pivot){
                left ++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 4, 2, 9, 8, 5};
        int[] array1 = new int[]{2, 5, 6, 7, 2, 5, 2, 5 , 4, 46, 2, 5, 1, 7 ,12};
        int[] array2 = new int[]{7, 4, 9, 2, 8, 5, 4};
        for (int i: quickSortAlgo1(array1,0, array1.length-1)){
            System.out.print(i+", ");
        }
        boolean[] as = new boolean[2];
//        as.length

    }
}
