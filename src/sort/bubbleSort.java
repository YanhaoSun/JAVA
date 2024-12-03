package sort;

public class bubbleSort {
    public static int[] bubbleSort(int[] array){
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length-i-1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 4, 2, 9, 8, 5};
        int[] array1 = new int[]{2, 5, 6, 7, 2, 5, 2, 5 , 4, 46, 2, 5, 1, 7 ,12};
        for (int i: bubbleSort(array)){
            System.out.print(i+", ");
        }
    }
}
