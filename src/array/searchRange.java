package array;
//二分搜索用来找一个数的边界
public class searchRange {
    public int[] searchRange1(int[] nums, int target)
    {
        if(nums.length==0)
        {
            return new int[]{-1, -1};
        }
        else if(target<nums[0])
        {
            return new int[]{-1, -1};
        }
        else if(nums[nums.length-1]<target)
        {
            return new int[]{-1, -1};
        }
        else if(nums[0]<=target && target<=nums[nums.length-1])
        {
            return new int[]{leftBorder(nums, target), rightBorder(nums, target)};
        }
        return new int[]{-1, -1};
    }
    public int rightBorder(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        int result=-1;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(target<nums[mid])
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
                result = mid;
            }
        }
        if(nums[result]==target)
        {
            return result;
        }
        else
        {
            return -1;
        }
    }
    public int leftBorder(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        int result=-1;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(nums[mid]<target)
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
                result = mid;
            }

        }
        if(nums[result]==target)
        {
            return result;
        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args) {
        searchRange test1 = new searchRange();
//        int[] nums1 = {5,7,7,8,8,10};
//        int target1 = 7;
//        int[] result1 = test1.searchRange1(nums1, target1);
//        for (int a: result1)
//        {
//            System.out.print(a+" ");
//        }

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] result2 = test1.searchRange1(nums2, target2);
        for (int a: result2)
        {
            System.out.print(a+" ");
        }

//        int[] nums3 = {};
//        int target3 = 4;
//        int[] result3 = test1.searchRange1(nums3, target3);
//        for (int a: result3)
//        {
//            System.out.print(a+" ");
//        }
    }
}
