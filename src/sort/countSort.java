package sort;

public class countSort {
    public static int[] countSortAlgo(int[] array){
        int min = array[0];
        int max = array[0];
        for (int i=0; i<array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] countArray = new int[max+1];
        for (int i=0; i<countArray.length; i++){
            int count = countHelper(array, i);
            countArray[i] = count;
        }
        int m = 0;
        for (int i=0; i<countArray.length; i++){
            if (countArray[i]>0){
                int count = countArray[i];
                for (int j=count; j>0; j--){
                    array[m++] = i;
                }
            }
        }
        return array;
    }
    public static int countHelper(int[] array, int index){
        int count = 0;
        for(int val: array){
            if (val==index){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] array = new int[]{7, 4, 2, 9, 8, 5};
        int[] array1 = new int[]{2, 5, 6, 7, 2, 5, 2, 5 , 4, 46, 2, 5, 1, 7 ,12};
        int[] array2 = new int[]{7, 4, 9, 2, 8, 5, 4};
//        countSortAlgo(array1);
        for (int i: countSortAlgo(array2)){
            System.out.print(i+", ");
        }
    }
}
