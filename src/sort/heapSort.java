package sort;

public class heapSort {
    public int[] heapSortAlgo(int[] array){
        for (int i = array.length/2; i>-1; i--){
            array = maxHeapModify(array, i, array.length-1);
        }

        for (int i = array.length-1; i>0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            array = maxHeapModify(array, 0, i-1);
        }
        return array;
    }

    public int[] maxHeapModify(int[] array, int start, int end){
        int dad = start;
        int son = 2*dad+1;
        while (son <= end){
            if ((son+1)<=end && array[son]<array[son+1]){
                son += 1;
            }
            if (array[dad] > array[son]){
                break;
            } else {
                int temp = array[dad];
                array[dad] = array[son];
                array[son] = temp;
                dad = son;
                son = 2*dad+1;
            }
        }
        return array;
    }

    public int[] heapSortAlgo1(int[] array){
        for (int i=array.length/2-1; i>-1; i--){
            maxHeapModify1(array, i, array.length-1);
        }
        for (int i=array.length-1; i>0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapModify1(array, 0, i-1);
        }
        return array;
    }

    public int[] maxHeapModify1(int[] array, int start, int end){
        int dad = start;
        int son = 2*dad+1;
        while (son<=end){
            if ((son+1)<=end && array[son]<array[son+1]){
                son ++;
            }
            if (array[son] < array[dad]){
                break;
            } else {
                int temp = array[dad];
                array[dad] = array[son];
                array[son] = temp;
                dad = son;
                son = 2*dad+1;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 4, 2, 9, 8, 5};
        int[] array1 = new int[]{2, 5, 6, 7, 2, 5, 2, 5 , 4, 46, 2, 5, 1, 7 ,12};
        heapSort heapSort = new heapSort();
        for (int i: heapSort.heapSortAlgo1(array1)){
            System.out.print(i+", ");
        }
    }
}
