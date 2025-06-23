package 线性表.数组.双指针技巧.左右指针.二分查找;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = leftBounds(nums, target);
        result[1] = rightBounds(nums, target);
        return result;
    }
    public static int leftBounds(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]>target){
                right = mid-1;
            } else if (nums[mid] < target){
                left = mid+1;
            } else if (nums[mid]==target){
                right = mid-1;
            }
        }
        if (left<0 || left>=nums.length){
            return -1;
        }
        return nums[left]==target? left:-1;
    }
    public static int rightBounds(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]<target){
                left = mid+1;
            } else if (nums[mid]>target){
                right = mid-1;
            } else if (nums[mid]==target){
                left = mid+1;
            }
        }
        if (right<0 || right>=nums.length){
            return -1;
        }
        return nums[right]==target? right:-1;
    }
}
