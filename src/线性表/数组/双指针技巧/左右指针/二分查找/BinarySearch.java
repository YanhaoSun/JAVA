package 线性表.顺序存储结构.Array.双指针技巧.左右指针.二分查找;


/**
 * 力扣704
 * easy
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]<target){
                left = mid+1;
            } else if (nums[mid]>target){
                right = mid-1;
            } else if (nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}
