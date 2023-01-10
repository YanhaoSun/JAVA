package array;

public class binarySearch {
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

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        binarySearch test1 = new binarySearch();
        int result1 = test1.search2(nums, target);
        System.out.println("result1 = "+result1);
    }
}
