package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class binarySearch {

    /**
        binarySearch limitation:
            (1)-only for ascending or descending order array
            (2)-array can not include duplicate elements
    * */
//    public int search(int[] nums, int target)
//    {
//        int left = 0;
//        int right = nums.length-1;
//        int mid = (left + right)/2;
//        if(target<nums[0] || target>nums[nums.length-1])
//        {
//            return -1;
//        }
//
//        boolean found = false;
//        while (!found)
//        {
//            if(left<=right)
//            {
//                if(target > nums[mid])
//                {
//                    left = mid+1;
//                    mid = (left + right)/2;
////                    System.out.println("left = "+left+" right = "+right+" mid = "+mid);
//                }
//                else if(target < nums[mid])
//                {
//                    right = mid-1;
//                    mid = (left + right)/2;
//                }
//                else
//                {
//                    found = true;
//                }
//            }
//            else
//            {
//                return -1;
//            }
//        }
//        return mid;
//    }

    //左闭右闭的写法
    public int left_close_right_close(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //左闭右开的写法
    public int left_close_right_open(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right){
            mid = left + ((right - left)/2);
            if (target < nums[mid]){
                right = mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    //左闭右闭的写法
    public int search1(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(nums[mid]>target)
            {
                right = mid-1;
            }
            else if(nums[mid]<target)
            {
                left = mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
    //左闭右开的写法
    public int search2(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length;
        int mid;
        while(left < right)
        {
            mid = left + ((right-left)>>1);
            System.out.println("mid = "+mid);
            if(nums[mid]>target)
            {
                right = mid;
            }
            else if(nums[mid]<target)
            {
                left = mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }

    public static int[] obtainArray1(int[] array, int left, int right){
        int[] result = new int[right+1-left];
        int re=0;
        for (int i=left; i<=right; i++){
            result[re++] = array[i];
        }
        return result;
    }
    public static int binarySearchModified(int[] nums, int result){
        if (nums.length==1){
            return nums[0];
        }
        int mid = nums.length/2;
        int l = nums.length;
        System.out.println("mid = "+mid);
        System.out.println("l = "+l);
        for(int val: nums){
            System.out.print(val+" ");
        }
        System.out.println();
        int left = binarySearchModified(obtainArray1(nums, 0, mid-1), result);
        int right = binarySearchModified(obtainArray1(nums, mid, nums.length-1), result);
        System.out.println("left = "+left);
        System.out.println("right = "+right);
        if (left+1!=right){
            result = left+1;
        }
        System.out.println("\n");
        return result;
    }
    public static int find(int[] nums){
        int findNum = 0;
        if (nums.length%2==0){
            int add = nums[0]-1;
            int[] evenArray = new int[nums.length+1];
            evenArray[0] = add;
            int i=1;
            for (int val: nums){
                evenArray[i++] = val;
            }
            findNum = binarySearchModified(evenArray, findNum);
        }else {
            findNum = binarySearchModified(nums, findNum);
        }
        return findNum;
    }


    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12,14,15,16,17,18,19,22,23,24,25,45,56,67};
//        int target = 0;
//        binarySearch test1 = new binarySearch();
//        int result1 = test1.left_close_right_close(nums, target);
//        int result2 = test1.left_close_right_open(nums, target);
//        System.out.println("result1 = "+result1);
//        System.out.println("result2 = "+result2);

//        int[] nums = {4, 5, 7, 8, 9};
//        int result = find(nums);
//        System.out.println(result);

        System.out.println(12%4);
        System.out.println(6%4);
    }
}
