package array;
//二分搜索用来找一个数的插入位置
import practices.Pra;

public class searchInsert {
    public int searchInsert1(int[] nums, int target) {
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
                System.out.println("get in");
                return mid;
            }
        }
        return right+1;
    }

    public static void main(String[] args) {
        searchInsert test1 = new searchInsert();
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int result1 = test1.searchInsert1(nums1, target1);
        System.out.println("result1 = "+result1);


        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int result2 = test1.searchInsert1(nums2, target2);
        System.out.println("result2 = "+result2);

        int[] nums3 = {-1, 0, 2, 4, 5, 7, 9, 10, 11};
        int target3 = 1;
        int result3 = test1.searchInsert1(nums3, target3);
        System.out.println("result3 = "+result3);

        int[] nums4 = {1};
        int target4 = 1;
        int result4 = test1.searchInsert1(nums4, target4);
        System.out.println("result4 = "+result4);
    }
}
