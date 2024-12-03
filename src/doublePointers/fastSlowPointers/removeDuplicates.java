package doublePointers.fastSlowPointers;

public class removeDuplicates {
    public static int removeDuplicateAlgo(int[] array, int target){
        int fast = 0;
        int slow = 0;
        for (; fast<array.length; fast++){
            if (array[fast]!=target){
                array[slow++] = array[fast];
            }
        }
        return slow;
    }

    public static int removeDuplicateAlgo1(int[] array, int target){
        int slow = 0;
        for (int fast = 0; fast<array.length; fast++){
            if (array[fast]!=target){
                array[slow++] = array[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4, 3, 5, 4, 6, 7, 8};
        int result = removeDuplicateAlgo1(array, 3);
        System.out.println(result);
    }
}
