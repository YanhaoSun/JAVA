package practices;

import array.ChangDuZuiXiaoShuZu;
import array.YouXuShuZuPingFang;
import array.elementRemoval;

public class review {
    public int leftCloseRightClose(int[] num, int target){
        int left = 0;
        int right = num.length-1;
        int mid = 0;
        while (left <= right){
            mid = left+((right-left)/2);
            if (target>num[mid]){
                left = mid+1;
            } else if (target<num[mid]){
                right = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int leftCloseRightOpen(int[] num, int target){
        int left = 0;
        int right = num.length;
        int mid = 0;
        while (left<right){
            mid = left + ((right-left)/2);
            if (target>num[mid]){
                left = mid+1;
            } else if (target<num[mid]){
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int elementRemoval(int[] num, int val){
        int slowIndex = 0;
        for(int i=0; i<num.length; i++){
            if(num[i]!=val){
                num[slowIndex++] = num[i];
            }
        }
        return slowIndex;
    }

    public static int[] sortedArraySquared(int[] array){
        int[] result = new int[array.length];
        int front = 0;
        int rear = array.length-1;
        int index = array.length-1;
        while (front<rear){
            if (array[front]*array[front]<=array[rear]*array[rear]){
                result[index] = array[rear]*array[rear];
                rear--;
            } else if(array[front]*array[front]>=array[rear]*array[rear]){
                result[index] = array[front]*array[front];
                front++;
            }
            index--;
        }
        return result;
    }
    public static int minLengthArray(int[] array, int val){
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
            while (sum>=val){
                result = Math.min(result, i-index+1);
                sum -= array[index++];
            }
        }
        return result;
    }
//    public int minLengthArray(int[] array, int val){
//        int sum = 0;
//        int result = Integer.MAX_VALUE;
//        int front = 0;
//        for(int i=0; i<array.length; i++){
//            sum += array[i];
//            while(sum>=val){
//                result = Math.min(result, i-front+1);
//                sum -= array[front++];
//            }
//        }
//        return result;
//    }
    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12,14,15,16,17,18,19,22,23,24,25,45,56,67};
//        int target = 17;
//        review test1 = new review();
//        int result1 = test1.leftCloseRightClose(nums, target);
//        int result2 = test1.leftCloseRightOpen(nums, target);
//        System.out.println("result1 = "+result1);
//        System.out.println("result2 = "+result2);


//        int[] nums = {0, 1, 2, 0, 2, 1, 4, 2};
//        int val = 1;
//        review test1 = new review();
//        int result = test1.elementRemoval(nums, val);
//        System.out.println("result = "+result);


//        int[] array = {-11,-4,-1,0,3,3,10};
//        int[] array1 = {-7,-3,2,3,11};
//        int[] array2 = {-9, -8, -2, -1, 0, 3, 5, 6, 9};
////        int[] result = YouXuShuZuPingFang.sortedArraySquare(array);
//        int[] result = sortedArraySquared(array1);
//        for(int a: result) {
//            System.out.print(a+" ");
//        }

        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1,1};
        System.out.println("min = "+ minLengthArray(nums, target));

    }
}

