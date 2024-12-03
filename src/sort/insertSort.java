package sort;

public class insertSort {
    public static int[] insertSortAlgo(int[] array){
        for (int i=1; i<array.length; i++){
            for (int j=i; j>0; j--){
                if (array[j]<array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertSortAlgo1(int[] array){
        for (int i=1; i<array.length; i++){
            for (int j=i; j>0; j--){
                if (array[j]<array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 5, 2, 5, 1};
        int[] test1 = {4, 2, 1, 5, 6, 3, 6, 1, 7};
        for(int i: insertSortAlgo1(test)){
            System.out.print(i+", ");
        }
    }
}
