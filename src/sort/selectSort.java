package sort;

public class selectSort {
    public static int[] selectSortAlgo(int[] array){
        int mini = 0;
        for (int i=0; i<array.length; i++){
            mini = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j]<array[mini]){
                    mini = j;
                }
            }
            int temp = array[i];;
            array[i] = array[mini];
            array[mini] = temp;
        }
        return array;
    }

    public static int[] selectSortAlgo1(int[] array){
        for (int i=0; i<array.length; i++){
            int min = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j]<array[min]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 5, 2, 5, 1};
        int[] test1 = {4, 2, 1, 5, 6, 3, 6, 1, 7};
        for(int i: selectSortAlgo1(test1)){
            System.out.print(i+", ");
        }
    }
}
