package practices;

import java.util.HashMap;

public class Pra2 {
    //左闭右闭
    public static int binarySearch1(int[] nums, int target)
    {
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(target<nums[mid])
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
    //左闭右开
    public static int binarySearch2(int[] nums, int target)
    {
        int left=0;
        int right=nums.length;
        int mid;
        while(left<right)
        {
            mid = left + ((right-left)>>1);
            if(target<nums[mid])
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
    public static void main(String[] args) {

    }
}