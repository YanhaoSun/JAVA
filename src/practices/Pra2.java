package practices;

import java.util.HashMap;

public class Pra2 {
    //左闭右闭
    public static int binarySearch1(int[] nums, int target)
    {
        int left=0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + ((right-left)/2);
            if(target<nums[mid]){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    //左闭右开
    public static int binarySearch2(int[] nums, int target)
    {
        int left=0;
        int right=nums.length;
        while (left<right){
            int mid = left+((right-left)/2);
            if(target<nums[mid]){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int Q()
    {
        int count=0;
        for(int i=0; i<1; i++)
        {
            for(int j=20; j>=0; j--)
            {
                count += j;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int a = Pra2.Q();
        System.out.println("a = "+a);
    }
}

