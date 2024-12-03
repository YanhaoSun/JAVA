package sort;

import java.util.ArrayList;
import java.util.List;

public class mergeSort {
    public static int[] merge(int[] arrayLeft, int[] arrayRight){
        int[] result = new int[arrayLeft.length+arrayRight.length];
        int i=0;
        int j=0;
        int re=0;
        while (i<arrayLeft.length && j<arrayRight.length){
            if(arrayLeft[i] < arrayRight[j]){
                result[re++] = arrayLeft[i++];
            } else {
                result[re++] = arrayRight[j++];
            }
        }
        if (i<arrayLeft.length){
            for (int m=i; m<arrayLeft.length; m++){
                result[re++] = arrayLeft[m];
            }
        }
        if (j<arrayRight.length){
            for (int m=j; m<arrayRight.length; m++){
                result[re++] = arrayRight[m];
            }
        }
        return result;
    }

    public static int[] mergeSortAlgo(int[] array){
        if (array.length<=1){
            return array;
        }
        int mid = array.length/2;
        int[] arrayLeft = mergeSortAlgo(obtainArray(array, 0, mid-1));
        int[] arrayRight = mergeSortAlgo(obtainArray(array, mid, array.length-1));
        array = merge(arrayLeft, arrayRight);
        return array;
    }

    public static int[] obtainArray(int[] array, int left, int right){
        int[] result = new int[(right+1)-left];
        int count=0;
        for (int i=left; i<=right; i++){
            result[count++] = array[i];
        }
        return result;
    }



    public static int[] merge1(int[] arrayLeft, int[] arrayRight){
        int i=0;
        int j=0;
        int re=0;
        int[] result = new int[arrayLeft.length+arrayRight.length];
        while (i<arrayLeft.length && j<arrayRight.length){
            if (arrayLeft[i]<arrayRight[j]){
                result[re++] = arrayLeft[i++];
            } else {
                result[re++] = arrayRight[j++];
            }
        }
        if (i<arrayLeft.length){
            for (int m=i; m<arrayLeft.length; m++){
                result[re++] = arrayLeft[m];
            }
        }
        if (j<arrayRight.length){
            for (int m=j; m<arrayRight.length; m++){
                result[re++] = arrayRight[m];
            }
        }
        return result;
    }

    public static int[] mergeSortAlgo1(int[] array){
        if (array.length<=1){
            return array;
        }
        int mid = array.length/2;
        int[] arrayLeft = mergeSortAlgo1(obtainArray1(array, 0, mid-1));
        int[] arrayRight = mergeSortAlgo1(obtainArray1(array, mid, array.length-1));
        int[] arrayMerged = merge1(arrayLeft, arrayRight);
        return arrayMerged;
    }

    public static int[] obtainArray1(int[] array, int left, int right){
        int[] result = new int[right+1-left];
        int re=0;
        for (int i=left; i<=right; i++){
            result[re++] = array[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = new int[]{7, 4, 2, 9, 8, 5};
        int[] array1 = new int[]{2, 5, 6, 7, 2, 5, 2, 5 , 4, 46, 2, 5, 1, 7 ,12};
        int[] array2 = new int[]{7, 4, 9, 2, 8, 5, 4};
        for (int i: mergeSortAlgo1(array1)){
            System.out.print(i+", ");
        }
    }
}